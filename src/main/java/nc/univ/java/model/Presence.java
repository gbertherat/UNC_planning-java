package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"seance_id", "etudiant_id"}))
@Getter @Setter
public class Presence implements Serializable {
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    Seance seance;

    @ManyToOne
    Etudiant etudiant;

    public Presence(){}

    public Presence(Seance seance){
        this.seance = seance;
    }

    public Presence(Seance seance, Etudiant etudiant){
        this.seance = seance;
        this.etudiant = etudiant;
    }
}
