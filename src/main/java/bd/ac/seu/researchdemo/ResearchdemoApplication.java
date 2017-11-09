package bd.ac.seu.researchdemo;

import bd.ac.seu.researchdemo.Models.Course;
import bd.ac.seu.researchdemo.Models.Faculty;
import bd.ac.seu.researchdemo.Models.Student;
import bd.ac.seu.researchdemo.repository.AttendenceDao;
import bd.ac.seu.researchdemo.repository.CourseDao;
import bd.ac.seu.researchdemo.repository.FacultyDao;
import bd.ac.seu.researchdemo.repository.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ResearchdemoApplication {

	LocalDateTime ldt = LocalDateTime.now();

	@Bean
	public CommandLineRunner demo(CourseDao courseDao, StudentDao studentDao, FacultyDao facultyDao,AttendenceDao attendenceDao) {
		return (String... args) -> {

//			courseDao.save(new Course("CSE4047", "Advance Java",3));
//			courseDao.save(new Course("CSE4048","Advace Java Lab",1));
//			courseDao.save(new Course("CSE1011","Programming Language I",3));
//			courseDao.save(new Course("CSE1012","Programming Language I Lab",1));
//			courseDao.save(new Course("CSE4035","Software Development and Project Management",3));
//			courseDao.save(new Course("CSE4036","Software Development and Project Management Lab",1));
//			courseDao.save(new Course("CSE2015","Programming Language II",3));
//			courseDao.save(new Course("CSE2016","Programming Language II Lab",1));
//			courseDao.save(new Course("CSE4013","Computer Graphics and Animation",3));
//			courseDao.save(new Course("CSE4014","Computer Graphics and Animation Lab",1));
//			courseDao.save(new Course("CSE3023","Computer Interfacing",3));
//			courseDao.save(new Course("CSE3024","Computer Interfacing Lab",1));
//
//			studentDao.save(new Student("2014100000017","Imran Khan"));
//			studentDao.save(new Student("2014100000018","Tamim Iqbal"));
//			studentDao.save(new Student("2014100000019","Shakib All Hassan"));
//			studentDao.save(new Student("2014100000020","Mashrafee Bin Mortoza"));
//			studentDao.save(new Student("2014100000021","Imrul kayes "));
//			studentDao.save(new Student("2014100000022","Musfiqur Rahim"));
//			studentDao.save(new Student("2014100000023","Sabbir Rahman"));
//			studentDao.save(new Student("2014100000024","soumya sarkar"));
//			studentDao.save(new Student("2014100000025","Mustafizur Rahman"));
//			studentDao.save(new Student("2014100000026","Rubel Hossain"));
//			studentDao.save(new Student("2014100000027","Mehedi Miraz"));
//			studentDao.save(new Student("2014100000028","Mahmudullah Riyad"));
//			studentDao.save(new Student("2014100000029","Mominul Haque"));
//
//			facultyDao.save(new Faculty(11111, "KMH","Monirul Hasan"));
//			facultyDao.save(new Faculty(11112, "SM","Shahriar Manzoor"));
//			facultyDao.save(new Faculty(11113, "RIK","Rezwan Islam Khan"));
//			facultyDao.save(new Faculty(11114, "AR","Ashiqur Rahman"));
//			facultyDao.save(new Faculty(11115, "HT","Hasan Taraque"));
//			facultyDao.save(new Faculty(11116, "MOSH","Mosharof Hossain Rubel"));
//			facultyDao.save(new Faculty(11117, "MAHB","Mahbub Hassan Mridul"));
//			facultyDao.save(new Faculty(11118, "SA","Sagufta Ashraf"));
//			facultyDao.save(new Faculty(11119, "RB","Rakib Hasan"));
//			facultyDao.save(new Faculty(11110, "AP","Anower Perves"));

//			Attendance attendance = new Attendance();
//			attendance.setDateTime(ldt);
//			attendenceDao.save(attendance);
//
		};
	}
	public static void main(String[] args) {

		SpringApplication.run(ResearchdemoApplication.class, args);
	}
}
