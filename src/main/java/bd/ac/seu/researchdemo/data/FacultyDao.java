package bd.ac.seu.researchdemo.data;


import bd.ac.seu.researchdemo.Models.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FacultyDao extends CrudRepository<Faculty,Integer>{
    List<Faculty> findByFacultyId(int id);
}
