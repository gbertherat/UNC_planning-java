package nc.univ.java.service;

import com.github.javafaker.Faker;
import nc.univ.java.model.*;
import nc.univ.java.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.IntStream;

@Component
public class Service {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private EtudiantRepository etuRepo;
    @Autowired
    private FormationRepository formRepo;
    @Autowired
    private NiveauRepository nivRepo;
    @Autowired
    private CoursRepository coursRepo;
    @Autowired
    private SalleRepository salleRepo;
    @Autowired
    private SeanceRepository seanceRepo;
    @Autowired
    private PresenceRepository presRepo;

    private final int numberOfFakeStudents = 1000;
    private final int numberOfFakeClass = 10;
    private final Random random = new Random();
    private final Faker faker = new Faker(new Locale("fr"));

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        createStaticDBData();
        createFakeDBData();
    }

    /* FAKE DATA GENERATION */
    public Etudiant createFakeStudent(){
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(faker.name().lastName());
        etudiant.setPrenom(faker.name().firstName());
        etudiant.setAge(faker.number().numberBetween(18, 30));
        etudiant.setAdresse(faker.address().streetAddress());
        return etudiant;
    }

    public Seance createFakeClass(){
        List<Cours> cours = new ArrayList<>();
        coursRepo.findAll().forEach(cours::add);

        List<Salle> salles = new ArrayList<>();
        salleRepo.findAll().forEach(salles::add);

        int heure = faker.number().numberBetween(7, 17);
        int minute = faker.number().numberBetween(0, 2) * 30;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, heure);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date debut = cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, heure + 2);
        cal.set(Calendar.MINUTE, minute);
        Date fin = cal.getTime();

        Salle salle = salles.get(random.nextInt(salles.size()));
        Seance seance = new Seance(salle);
        seance.setCours(cours.get(random.nextInt(cours.size())));
        seance.setDatedebut(debut);
        seance.setDatefin(fin);

        List<Seance> seances = seanceRepo.findBySalleNom(salle.getNom());
        boolean heureDebutNoConflict =
                seances.stream().noneMatch(seanceInDb -> seanceInDb.getDatedebut().compareTo(debut) * debut.compareTo(seanceInDb.getDatefin()) >= 0);
        boolean heureFinNoConflict =
                seances.stream().noneMatch(seanceInDb -> seanceInDb.getDatedebut().compareTo(fin) * fin.compareTo(seanceInDb.getDatefin()) >= 0);

        if(heureDebutNoConflict && heureFinNoConflict){
            return seance;
        }
        return createFakeClass();
    }

    public void createStaticDBData() {
        Arrays.stream(FormationEnum.values()).forEach(libelle -> formRepo.save(new Formation(libelle)));
        Arrays.stream(CoursEnum.values()).forEach(cours -> coursRepo.save(new Cours(cours.toString())));

        Arrays.stream(SalleEnum.values()).forEach(code ->
                IntStream.range(1, code.getNombreDeSalle() + 1).forEach(i -> {
                    Salle salle = new Salle();
                    salle.setCode(code.toString().charAt(0));
                    salle.setCapacite(code.getCapacite());
                    salle.setNom(code.toString().charAt(0) + "" + i);
                    salleRepo.save(salle);
                }));
    }

    public void addRandomEtudiantToSeance(Seance seance){
        List<Etudiant> etudiants = new ArrayList<>();
        etuRepo.findAll().forEach(etudiants::add);

        Etudiant randEtu = etudiants.get(random.nextInt(etudiants.size()));
        Presence presence = new Presence(seance);
        boolean etuDejaPresent =
                randEtu.getPresences().stream().anyMatch(pres -> pres.getSeance() == presence.getSeance());
        boolean conflitHeureDebut =
                randEtu.getPresences().stream().anyMatch(pres -> pres.getSeance().getDatedebut().compareTo(seance.getDatedebut()) * seance.getDatedebut().compareTo(pres.getSeance().getDatefin()) >= 0);
        boolean conflitHeureFin =
                randEtu.getPresences().stream().anyMatch(pres -> pres.getSeance().getDatedebut().compareTo(seance.getDatefin()) * seance.getDatefin().compareTo(pres.getSeance().getDatefin()) >= 0);

        //seances.stream().noneMatch(seanceInDb -> seanceInDb.getDatedebut().compareTo(debut) * debut.compareTo(seanceInDb.getDatefin())
        if(!etuDejaPresent && !conflitHeureDebut && !conflitHeureFin){
            presence.setEtudiant(randEtu);
            randEtu.addPresence(presence);
            presRepo.save(presence);
            etuRepo.save(randEtu);
        }
    }

    public void createFakeDBData() {
        List<Formation> formations = new ArrayList<>();
        formRepo.findAll().forEach(formations::add);

        IntStream.range(0, numberOfFakeStudents).forEach(index -> {
            Etudiant etudiant = createFakeStudent();
            etuRepo.save(etudiant);

            Niveau niveau = new Niveau(etudiant);
            niveau.setFormation(formations.get(random.nextInt(formations.size())));
            niveau.setAnnee(faker.number().numberBetween(1, 3));
            nivRepo.save(niveau);
        });

        IntStream.range(0, numberOfFakeClass).forEach(index -> {
            Seance seance = createFakeClass();
            seanceRepo.save(seance);
            IntStream.range(0, faker.number().numberBetween(numberOfFakeStudents/3, numberOfFakeStudents/2)).forEach(number -> {
                addRandomEtudiantToSeance(seance);
            });
        });
    }
    /* */

    public void printDatabaseDetail() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery("SHOW TABLES;");

        while (set.next()) {
            String tableName = set.getString(1);
            System.out.println("-- TABLE : " + tableName + " --");
            Statement state = connection.createStatement();
            ResultSet stateResult = state.executeQuery("SELECT column_name, type_name FROM information_schema.columns WHERE table_name='" + tableName + "'");
            while (stateResult.next()) {
                System.out.println("Colonne " + stateResult.getString(1) + " de type " + stateResult.getString(2));
            }
        }
    }

    public List<Salle> getAllSalles(){
        List<Salle> salles = new ArrayList<>();
        salleRepo.findAll().forEach(salles::add);
        return salles;
    }

    public Optional<Salle> getSalleById(long id){
        return salleRepo.findById(id);
    }

    public List<Cours> getAllCours(){
        List<Cours> cours = new ArrayList<>();
        coursRepo.findAll().forEach(cours::add);
        return cours;
    }

    public Optional<Cours> getCoursById(long id){
        return coursRepo.findById(id);
    }

    public List<Etudiant> getAllEtudiants(){
        return new ArrayList<>(etuRepo.findAllByOrderByNom());
    }

    public Optional<Etudiant> getEtudiantById(long id){
        return etuRepo.findById(id);
    }
}
