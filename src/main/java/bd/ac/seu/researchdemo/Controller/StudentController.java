package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.Attendance;
import bd.ac.seu.researchdemo.Models.Registration;
import bd.ac.seu.researchdemo.Models.Section;
import bd.ac.seu.researchdemo.Models.Student;
import bd.ac.seu.researchdemo.repository.AttendenceDao;
import bd.ac.seu.researchdemo.repository.RegistrationDao;
import bd.ac.seu.researchdemo.repository.SectionDao;
import bd.ac.seu.researchdemo.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentDao studentDao;
    @Autowired
    RegistrationDao registrationDao;

    @Autowired
    AttendenceDao attendenceDao;

    @Autowired
    SectionDao sectionDao;

    List<Registration> registrationList,registrationList1;

    String Sid;
    int secId;
    Student student;
    Section courseName;

    List<Attendance> attendanceList;
    public void commonModelAttributes(Model model){
        model.addAttribute("home","HOME");
        model.addAttribute("homePath","/student/home");
        model.addAttribute("students","STUDENTS");
        model.addAttribute("studentPath","/student/classmates");
        model.addAttribute("about","ABOUT");
        model.addAttribute("aboutPath","/student/about");
        model.addAttribute("sectionList", registrationList);
        model.addAttribute("courseTotlepath","getSection().getCourse().getCourseTitle()");
    }



    @RequestMapping(value = "")
    public String login() {
        return "Student_login";
    }

    @RequestMapping(value = "courses", method = RequestMethod.GET)
    private String home(Model model, @RequestParam String id) {
        Sid = id;
        student = studentDao.findOne(id);
        List<Student> studentList = studentDao.findByStudentId(id);
        registrationList = registrationDao.findByStudentStudentId(id);
        if (studentList.size() > 0) {
            model.addAttribute("title", student.getStudentName());
            model.addAttribute("registrationList", registrationList);
            commonModelAttributes(model);

        } else {
            model.addAttribute("title", "You have not registered any course in this semester");
        }
        return "Student_courses";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    private String stream(Model model, @RequestParam(required = false) Integer ids) {

        try {
            secId = ids;
            courseName = sectionDao.findOne(secId);
            registrationList1 = registrationDao.findBySectionId(secId);
        }catch (Exception e){

        }

        model.addAttribute("courseTitle",courseName.getCourse().getCourseTitle());
        model.addAttribute("facultyName", courseName.getFaculty().getFacultyName());
        model.addAttribute("registrationList", registrationList);
        commonModelAttributes(model);

        return "Student_home";
    }


    @RequestMapping(value = "classmates")
    private String homeClassmate(Model model) {


        model.addAttribute("title", student.getStudentName());
        model.addAttribute("List3", registrationList1);
        model.addAttribute("tempId", Sid);
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        commonModelAttributes(model);


        return "Student_classmates";
    }

    @RequestMapping(value = "about")
    private String homeAbout(Model model) {
        model.addAttribute("title", student.getStudentName());
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        commonModelAttributes(model);
        return "Student_about";
    }

    @RequestMapping(value = "attendance_status",method = RequestMethod.GET)
    private String showAttendenceStatus(Model model){
        attendanceList = attendenceDao.findByStudentStudentIdAndSectionId(Sid,secId);

        model.addAttribute("title", student.getStudentName());
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        model.addAttribute("List6", attendanceList);
        commonModelAttributes(model);


        return  "attendanceStatus";

    }





}
