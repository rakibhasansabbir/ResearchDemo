package bd.ac.seu.researchdemo.Models.data;

import bd.ac.seu.researchdemo.Models.registration;
import bd.ac.seu.researchdemo.Models.student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentDao  extends CrudRepository<student,Integer>{
}
