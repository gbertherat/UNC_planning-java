package nc.univ.java.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ETUDIANT")
@Getter
public class Etudiant {
    @Id @GeneratedValue long id;
}
