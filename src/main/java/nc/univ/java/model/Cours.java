package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Cours {
    @Id @GeneratedValue
    long id;

    @Column(nullable = false)
    String libelle;

    public Cours(){}

    public Cours(String libelle){
        this.libelle = libelle;
    }
}
