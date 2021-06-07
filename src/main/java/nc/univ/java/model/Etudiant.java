package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    Presences presences;
}
