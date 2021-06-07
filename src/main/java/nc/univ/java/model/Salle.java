package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Salle {
    @Id @GeneratedValue
    long id;

    @Column(nullable = false)
    String nom;

    @Column(nullable = false)
    char code;

    @Column(nullable = false)
    int capacite;
}
