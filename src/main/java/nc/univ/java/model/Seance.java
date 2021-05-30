package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","salle_id"}))
@Getter
public class Seance implements Serializable {
    @Id
    @GeneratedValue
    long id;

    @OneToOne
    Salle salle;

    @ManyToOne
    Cours cours;
}
