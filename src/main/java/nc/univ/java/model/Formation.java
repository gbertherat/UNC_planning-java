package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
public class Formation {
    @Id
    @GeneratedValue
    long id;

    @Column(nullable = false)
    String libelle;
}
