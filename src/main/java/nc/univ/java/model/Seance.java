package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","salle_id"}))
@Getter @Setter
public class Seance implements Serializable {
    @Id
    @GeneratedValue
    long id;

    @OneToOne
    Salle salle;

    @ManyToOne
    Cours cours;

    @Column
    Date datedebut;

    @Column
    Date datefin;

    public Seance(){}

    public Seance(Salle salle){
        this.salle = salle;
    }
}
