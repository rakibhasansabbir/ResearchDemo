package bd.ac.seu.researchdemo.Service;

import bd.ac.seu.researchdemo.Models.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public interface SectionDao extends CrudRepository<Section,Integer> {


}
