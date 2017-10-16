package bd.ac.seu.researchdemo.Models.data;


import bd.ac.seu.researchdemo.Models.Teachers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeachersDao  extends CrudRepository<Teachers,Integer>{
}
