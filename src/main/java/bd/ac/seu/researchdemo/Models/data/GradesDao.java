package bd.ac.seu.researchdemo.Models.data;

import bd.ac.seu.researchdemo.Models.grades;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GradesDao extends CrudRepository<grades,Integer> {
}
