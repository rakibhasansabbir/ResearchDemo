package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.*;
import bd.ac.seu.researchdemo.repository.*;
import bd.ac.seu.researchdemo.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.File;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FacultyController {
    @Autowired
    FacultyDao facultyDao;
    @Autowired
    SectionDao sectionDao;
    @Autowired
    RegistrationDao registrationDao;
    @Autowired
    ClassAnnouncementsDao classAnnouncementsDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    SemesterDao semesterDao;
    @Autowired
    AttendenceDao attendenceDao;

    LocalDateTime DTime;
    String getDateTime;

    List<Registration> registrationList;
    List<Section> sectionList;

    int secId, Fid;
    Faculty faculty;
    Section section;
    Section courseName;
    Semester semester;
    Student student;
    LocalDateTime localDateTime;
    AttendenceStatus attendenceStatus;

    public void commonModelAttributes(Model model){
        model.addAttribute("home","HOME");
        model.addAttribute("homePath","/home");
        model.addAttribute("students","STUDENTS");
        model.addAttribute("studentPath","/students");
        model.addAttribute("about","ABOUT");
        model.addAttribute("aboutPath","/about");
        model.addAttribute("courseTotlepath","Course.getCourse().getCourseTitle()");
    }

    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "courses", method = RequestMethod.GET)
    private String home(Model model, @RequestParam int id) {
        Fid = id;
        faculty = facultyDao.findOne(id);
        List<Faculty> facultyList = facultyDao.findByFacultyId(id);
        sectionList = sectionDao.findByFacultyFacultyId(id);
        if (facultyList.size() > 0) {
            model.addAttribute("facultyName", faculty.getFacultyName());
            model.addAttribute("sectionList", sectionList);
            model.addAttribute("tempId", Fid);

        } else {
            model.addAttribute("title", "You have not registered any course in this semester");
        }
        return "courses";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    private String stream(Model model, @RequestParam(required = false) Integer ids) {

        try {
            secId = ids;
            registrationList = registrationDao.findBySectionId(secId);
            courseName = sectionDao.findOne(ids);

        } catch (Exception e) {

        }
        model.addAttribute("attendance","Attendance");
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute("post", "POST");
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        model.addAttribute(new ClassAnnouncements());
        commonModelAttributes(model);
        return "home";
    }

    @RequestMapping(value = "home", method = RequestMethod.POST)
    private String homeStream(@ModelAttribute @Valid ClassAnnouncements
                                      announcements, Model model) {

        String status = announcements.getAnnouncements();
        File file = announcements.getFile();
        model.addAttribute("attendance","Attendance");
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        commonModelAttributes(model);

        classAnnouncementsDao.save(new ClassAnnouncements(status, file,
                LocalDateTime.now(), sectionDao.findOne(secId)));
        return "home";
    }

    @RequestMapping(value = "students")
    private String homeClassmate(Model model) {

        model.addAttribute("attendance","Attendance");
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("List3", registrationList);
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        commonModelAttributes(model);
        return "students";
    }

    @RequestMapping(value = "about")
    private String homeAbout(Model model) {

        model.addAttribute("attendance","Attendance");
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute("post", "POST");
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        commonModelAttributes(model);
        return "about";
    }

    @RequestMapping(value = "attendance", method = RequestMethod.GET)
    private String attendance(@ModelAttribute @Valid Attendance attendance,
                              Errors errors, Model model,
                              @RequestParam
                              @DateTimeFormat(pattern = "yyyy-MM-dd") String dateTime) {
        List<AttendenceService> attendenceServiceList = new ArrayList<>();
        int count = 1;
        DTime = LocalDateTime.parse(dateTime);
        getDateTime = dateTime;

        for (Registration registration : registrationList) {

            //Total present
            List<Attendance> attendanceList1 = attendenceDao.
                    findByAttendenceStatusAndSection_IdAndStudentStudentId
                            (AttendenceStatus.PRESENT, secId, registration.getStudent().getStudentId());
            int totalpresent = attendanceList1.size();

            //Total Absent
            attendanceList1 = attendenceDao.
                    findByAttendenceStatusAndSection_IdAndStudentStudentId
                            (AttendenceStatus.ABSENT, secId, registration.getStudent().getStudentId());
            int totalabsent = attendanceList1.size();

            attendenceServiceList.add(new AttendenceService
                    (count, registration.getStudent().getStudentId(),
                            registration.getStudent().getStudentName(),
                            totalpresent, totalabsent, registration.getSection().getId(),
                            registration.getSemester().getSemesterId()));

            count++;
        }

        model.addAttribute("AttendenceList", attendenceServiceList);
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute(new Attendance());
        model.addAttribute("attendanceT", Type.values());
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        commonModelAttributes(model);
        return "attendance";
    }

    @RequestMapping(value = "attendance", method = RequestMethod.POST)
    private String getAttendance(@ModelAttribute @Valid Attendance attendance, Errors errors,
                                 Model model, @RequestParam(required = false) String[] id) {
        System.out.println("Test one");
        List<Attendance> attendanceList;
        String currentDateTime = String.valueOf(LocalDateTime.now());
        String splitCurrentDate = currentDateTime.split("T")[0];
        String splitGetDate = getDateTime.split("T")[0];
        List<Attendance> attendanceList1 = (List<Attendance>) attendenceDao.findAll();

        int i;
        for (Registration registration : registrationList) {
            registration = registrationDao.findOne(registration.getId());
            student = studentDao.findOne(registration.getStudent().getStudentId());
            registration.getSemester().getSemesterId();
            semester = semesterDao.findOne(registration.getSemester().getSemesterId());
            section = sectionDao.findOne(registration.getSection().getId());
            try {
                for (i = 0; i < id.length; i++) {
                    if (registration.getStudent().getStudentId().equals(id[i])) {
                        attendenceStatus = AttendenceStatus.PRESENT;
                        break;
                    } else {
                        attendenceStatus = AttendenceStatus.ABSENT;
                    }
                }
            } catch (Exception e) {
                attendenceStatus = AttendenceStatus.ABSENT;
            }

            //check attendance table empty or not
            if (attendanceList1.size() == 0) {
                attendenceDao.save(new Attendance(student, section,
                        attendance.getType(),
                        attendenceStatus,
                        DTime, semester));
            } else {
                for (int j = 0, falsecount = 0; j < attendanceList1.size(); j++) {
                    Attendance attendance1 = attendanceList1.get(j);

                    //get all from attendance table
                    String DateTime = String.valueOf(attendance1.getDateTime());
                    String splitDate = DateTime.split("T")[0];
                    int sectionId = attendance1.getSection().getId();
                    String studentId = attendance1.getStudent().getStudentId();
                    int sectionReg = registration.getSection().getId();
                    String studentReg = registration.getStudent().getStudentId();

                    //check same date repetation or not
                    if (sectionId == sectionReg && splitDate.equals(splitGetDate)
                            && studentId.equals(studentReg)) {

                        System.out.println("Already Insert");

                    } else {
                        falsecount++;
                        if (falsecount == attendanceList1.size()) {
                            attendenceDao.save(new Attendance(student, section,
                                    attendance.getType(),
                                    attendenceStatus,
                                    DTime, semester));
                        }
                    }
                }
            }
        }


        attendanceList = attendenceDao.findBySectionId(secId);
        attendanceList.stream().forEach(System.out::println);
        model.addAttribute("List6", attendanceList);
        model.addAttribute("sectionList", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute("courseTitle",
                courseName.getCourse().getCourseTitle());
        model.addAttribute("attendenceTitle",
                "Attendence for " + section.getCourse().getCourseTitle()
                        + " section " + secId);
        commonModelAttributes(model);

        return "attendanceStatus";
    }
}