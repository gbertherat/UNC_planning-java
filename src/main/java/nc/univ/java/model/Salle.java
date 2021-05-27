package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "SALLE")
@Getter
public class Salle {
    @Id @GeneratedValue
    long id;

    @Column
    String nom;

    @Column
    String code;

    @Column
    int capacite;
}
