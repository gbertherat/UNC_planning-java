package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ETUDIANT")
@Getter
public class Etudiant {
    @Id @GeneratedValue
    long id;

    @Column
    String nom;

    @Column
    String prenom;

    @Column
    int age;

    @Column
    String adress;
}
