package nc.univ.java.model;

import com.zaxxer.hikari.util.FastList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter @Setter
public class Cours {
    @Id @GeneratedValue
    long id;

    @Column(nullable = false)
    String libelle;

    @ManyToMany
    Set<Formation> formations;

    public void addFormation(Formation formation){
        this.formations.add(formation);
    }

    public Cours(){
        this.formations = new HashSet<>();
    }

    public Cours(String libelle){
        this.libelle = libelle;
        this.formations = new HashSet<>();
    }
}
