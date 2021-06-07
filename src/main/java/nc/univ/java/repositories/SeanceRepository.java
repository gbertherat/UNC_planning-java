package nc.univ.java.repositories;

import nc.univ.java.model.Seance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeanceRepository extends CrudRepository<Seance, Long> {
    List<Seance> findAllByOrderBySalleId();
    List<Seance> findBySalleNom(String nom);
}
