package nc.univ.java.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    @OneToMany(mappedBy = "seance")
    Set<Presence> presences;

    public void addPresence(Presence presence){
        this.presences.add(presence);
    }

    public Seance(){
        this.presences = new HashSet<>();
    }

    public Seance(Salle salle){
        this.presences = new HashSet<>();
        this.salle = salle;
    }
}
