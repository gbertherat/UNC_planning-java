package nc.univ.java.repositories;

import nc.univ.java.model.Niveau;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NiveauRepository extends CrudRepository<Niveau, Long> {
    Optional<Niveau> getByEtudiantId(long id);
}
