package nc.univ.java.repositories;

import nc.univ.java.model.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
}
