package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","seance_id"}))
@Getter @Setter
public class Presences implements Serializable {
    @Id
    @GeneratedValue
    long id;

    @OneToOne
    Seance seance;

    @OneToMany(mappedBy = "presences")
    Collection<Etudiant> etudiants;
}
