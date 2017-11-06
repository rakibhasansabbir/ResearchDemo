package bd.ac.seu.researchdemo.repository;

import bd.ac.seu.researchdemo.Models.Attendance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AttendenceDao extends CrudRepository<Attendance,Integer> {
    public List<Attendance> findBySectionId(int id);
    public List<Attendance> findByAttendenceStatusAndSection_IdAndStudentStudentId(String attendendenceStatus,int sectionId,String studentId);
    public List<Attendance> findBySectionIdAndStudentStudentId(int secId,String studentId);

}
