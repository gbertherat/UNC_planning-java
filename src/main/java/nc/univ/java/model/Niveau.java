package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","etudiant_id"}))
@Getter @Setter
public class Niveau {
    @Id @GeneratedValue
    int id;

    @OneToOne
    Etudiant etudiant;

    @ManyToOne
    Formation formation;

    @Column
    int annee;

    public Niveau(){}

    public Niveau(Etudiant etudiant){
        this.etudiant = etudiant;
    }
}
