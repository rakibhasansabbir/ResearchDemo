package bd.ac.seu.researchdemo.Service;


import bd.ac.seu.researchdemo.Models.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FacultyDao extends CrudRepository<Faculty,Integer>{
}
