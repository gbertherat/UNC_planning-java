package nc.univ.java.repositories;

import nc.univ.java.model.Etudiant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {
    List<Etudiant> findAllByOrderByNom();
}
