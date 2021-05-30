package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
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
