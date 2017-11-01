package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.*;
import bd.ac.seu.researchdemo.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller

public class CourseController {
    @Autowired
    FacultyDao facultyDao;
    @Autowired
    SectionDao sectionDao;
    @Autowired
    RegistrationDao registrationDao;

    @Autowired
    StudentDao studentDao;
    @Autowired
    SemesterDao semesterDao;

    @Autowired
    AttendenceDao attendenceDao;
    String DTime;
    Registration registration;

    List<Registration> registrationList;
    List<Section> sectionList;
    int secId, Fid;
    int i = 0;

    Faculty faculty;
    Section section;
    LocalDateTime localDateTime;

    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "home", method = RequestMethod.GET)
    private String home(Model model, @RequestParam int id) {
        Fid = id;
        section = sectionDao.findOne(id);
        faculty = facultyDao.findOne(id);
        List<Faculty> facultyList = facultyDao.findByFacultyId(id);
        sectionList = sectionDao.findByFacultyFacultyId(id);
        if (facultyList.size() > 0) {
            model.addAttribute("title", faculty.getFacultyName());
            model.addAttribute("List1", sectionList);
            model.addAttribute("tempId", Fid);

        } else {
            model.addAttribute("title", "You have not registered any course in this semester");
        }
        return "index";
    }

    @RequestMapping(value = "stream", method = RequestMethod.GET)
    private String stream(Model model, @RequestParam int ids) {

        secId = ids;
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        return "stream";
    }

    @RequestMapping(value = "stream1")
    private String homeStream(Model model) {
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        return "stream";
    }

    @RequestMapping(value = "classmates1")
    private String homeClassmate(Model model) {

        registrationList = registrationDao.findBySectionId(secId);
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("List3", registrationList);
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        return "classmates";
    }

    @RequestMapping(value = "about")
    private String homeAbout(Model model) {

        LocalDateTime dateTime = LocalDateTime.now();

        model.addAttribute("dateTime", dateTime);
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        return "about";
    }


    @RequestMapping(value = "attendance", method = RequestMethod.GET)
    private String attendance(@ModelAttribute @Valid Attendance attendance,
                              Errors errors, Model model, @RequestParam String bday) {
        DTime = bday;
        Registration registration;

        model.addAttribute("List6", registrationList);
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute(new Attendance());
        model.addAttribute("attendanceType", Type.values());
        return "attendance";
    }

    @RequestMapping(value = "attendance", method = RequestMethod.POST)
    private String getAttendance(@ModelAttribute @Valid Attendance attendance,
                                 Errors errors, Model model, @RequestParam int[] id) {

        AttendenceStatus attendenceStatus = null;
        for (Registration registration : registrationList) {
            registration = registrationDao.findOne(registration.getId());
            Student student = studentDao.findOne(registration.getStudent().getStudentId());
            localDateTime = LocalDateTime.now();
            registration.getSemester().getSemesterId();
            Semester semester = semesterDao.findOne(registration.getSemester().getSemesterId());
            Section section = sectionDao.findOne(registration.getSection().getId());

            List<Attendance> attendanceList = attendenceDao
                    .findByDateTimeAndStudentStudentIdAndAttendanceDetails
                            (localDateTime, student, attendance.getAttendanceDetails());
            for (Attendance attendance1 : attendanceList) {
                if (attendance1.getStudent().getStudentId()
                        != attendance.getStudent().getStudentId()) {
                    attendenceStatus = AttendenceStatus.PRESENT;
                    attendenceDao.save(new Attendance(student, section, attendance.getType(),
                            attendenceStatus,
                            localDateTime, semester, attendance.getAttendanceDetails()));
                }
            }

        }
        List<Attendance> attendanceList = attendenceDao.findBySectionId(secId);
        model.addAttribute("List6", attendanceList);
        model.addAttribute("date", DTime);
        model.addAttribute("title");

        return "attendanceStatus";
    }


}