package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","etudiant_id"}))
@Getter
public class Niveau {
    @Id @GeneratedValue
    int id;

    @OneToOne
    Etudiant etudiant;

    @ManyToOne
    Formation formation;
}
