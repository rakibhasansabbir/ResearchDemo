package bd.ac.seu.researchdemo.Service;

import bd.ac.seu.researchdemo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentDao  extends CrudRepository<Student,String>{
}
