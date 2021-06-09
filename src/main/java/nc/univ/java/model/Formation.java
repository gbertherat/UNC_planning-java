package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter @Setter
public class Formation {
    @Id
    @GeneratedValue
    long id;

    @Column(nullable = false)
    String libelle;

    @ManyToMany(mappedBy = "formations")
    Set<Cours> cours;

    public void addCours(Cours cours){
        this.cours.add(cours);
    }

    public Formation(){
        this.cours = new HashSet<>();
    }

    public Formation(FormationEnum formation){
        this.cours = new HashSet<>();
        libelle = formation.toString();
    }
}
