package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
public class Formation {
    @Id
    @GeneratedValue
    long id;

    @Column(nullable = false)
    String libelle;

    public Formation(){ }

    public Formation(FormationEnum formation){
        libelle = formation.toString();
    }
}
