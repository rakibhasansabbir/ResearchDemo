package bd.ac.seu.researchdemo.data;

import bd.ac.seu.researchdemo.Models.Attendance;
import bd.ac.seu.researchdemo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface AttendenceDao extends CrudRepository<Attendance,Integer> {
    public List<Attendance> findBySectionId(int id);
    public List<Attendance> findByDateTimeAndStudentStudentIdAndAttendanceDetails(LocalDateTime dateTime, Student stid, String stdetails);



}
