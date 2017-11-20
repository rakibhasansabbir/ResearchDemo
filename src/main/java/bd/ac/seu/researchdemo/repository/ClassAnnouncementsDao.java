package bd.ac.seu.researchdemo.repository;

import bd.ac.seu.researchdemo.Models.ClassAnnouncements;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClassAnnouncementsDao extends
        CrudRepository<ClassAnnouncements,Integer>{
}
