package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table
@Getter @Setter
public class Etudiant {
    @Id @GeneratedValue
    long id;

    @Column(nullable = false)
    String nom;

    @Column(nullable = false)
    String prenom;

    @Column(nullable = false)
    int age;

    @Column
    String adresse;

    @OneToMany(mappedBy="etudiant", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    Collection<Presence> presences;

    public void addPresence(Presence presence){
        presences.add(presence);
    }

    public Etudiant(){
        presences = new ArrayList<>();
    }
}
