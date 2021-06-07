package nc.univ.java.repositories;

import nc.univ.java.model.Cours;
import org.springframework.data.repository.CrudRepository;

public interface CoursRepository extends CrudRepository<Cours, Long> {
}
