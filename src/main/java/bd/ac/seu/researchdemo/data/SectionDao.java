package bd.ac.seu.researchdemo.data;

import bd.ac.seu.researchdemo.Models.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SectionDao extends CrudRepository<Section,Integer> {
    List<Section> findByFacultyFacultyId(int fid);


}
