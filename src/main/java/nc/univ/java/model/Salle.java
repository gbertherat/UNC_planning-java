package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
public class Salle {
    @Id @GeneratedValue
    long id;

    @Column(nullable = false)
    String nom;

    @Column(nullable = false)
    String code;

    @Column(nullable = false)
    int capacite;
}
