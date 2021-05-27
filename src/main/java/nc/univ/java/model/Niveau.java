package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
public class Niveau {
    @Id @GeneratedValue
    int id;

    @Column
    String code;

    @Column
    String libelle;
}
