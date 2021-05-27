package nc.univ.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ETUDIANT")
public class Etudiant {
    @Id @GeneratedValue long id;
}
