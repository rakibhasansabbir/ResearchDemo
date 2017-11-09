package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.*;
import bd.ac.seu.researchdemo.repository.*;
import bd.ac.seu.researchdemo.service.AttendenceService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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



    LocalDateTime DTime;
    String getDateTime;
    Registration registration;

    List<Registration> registrationList;
    List<Section> sectionList;
    ArrayList<String> stringArrayList;


    int secId, Fid;
    int k = 0;


    Faculty faculty;
    Section section;
    Semester semester;
    Student student;
    LocalDateTime localDateTime;
    AttendenceStatus attendenceStatus;

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
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("title", faculty.getFacultyName());
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
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


        for (Registration registration : registrationList){

            //Total present
            List<Attendance> attendanceList1 = attendenceDao.
                    findByAttendenceStatusAndSection_IdAndStudentStudentId
                            (AttendenceStatus.PRESENT,secId,registration.getStudent().getStudentId());
            int totalpresent = attendanceList1.size();

            //Total Absent
            attendanceList1 = attendenceDao.
                    findByAttendenceStatusAndSection_IdAndStudentStudentId
                            (AttendenceStatus.ABSENT,secId,registration.getStudent().getStudentId());
            int totalabsent = attendanceList1.size();

            attendenceServiceList.add(new AttendenceService
                    (count,registration.getStudent().getStudentId(),
                            registration.getStudent().getStudentName(),
                            totalpresent,totalabsent,registration.getSection().getId(),
                            registration.getSemester().getSemesterId()));

            count++;
        }


        model.addAttribute("AttendenceList", attendenceServiceList);
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute(new Attendance());
        model.addAttribute("attendanceType", Type.values());
        return "attendance";
    }

    @RequestMapping(value = "attendance", method = RequestMethod.POST)
    private String getAttendance(@ModelAttribute @Valid Attendance attendance,
                                 Errors errors, Model model, @RequestParam String[] id) {

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

            for (i = 0; i < id.length; i++) {
                if (registration.getStudent().getStudentId().equals(id[i])) {
                    attendenceStatus = AttendenceStatus.PRESENT;
                    break;
                } else {
                    attendenceStatus = AttendenceStatus.ABSENT;

                }
            }
            if (attendanceList1.size() == 0){
                attendenceDao.save(new Attendance(student, section,
                    attendance.getType(),
                    attendenceStatus,
                    DTime, semester));

            }else {
                for (int j = 0; j<1; j++){

                    Attendance attendance1 = attendanceList1.get(k);
                    k++;
                    if (attendanceList1.size() == k){
                        k =0;
                    }

                    String DateTime = String.valueOf(attendance1.getDateTime());
                    String splitDate = DateTime.split("T")[0];
                    int sectionId = attendance1.getSection().getId();
                    String studentId = attendance1.getStudent().getStudentId();

                    int sectionReg = registration.getSection().getId();
                    String studentReg = registration.getStudent().getStudentId();
                    if (splitDate.equals(splitGetDate)
                            && sectionId == sectionReg
                            && studentId.equals(studentReg)){

                        System.out.println("Already Insert");



                    }else {
                        attendenceDao.save(new Attendance(student, section,
                                attendance.getType(),
                                attendenceStatus,
                                DTime, semester));
                    }
                }

            }

        }






        attendanceList = attendenceDao.findBySectionId(secId);
        attendanceList.stream().forEach(System.out::println);
        model.addAttribute("List6", attendanceList);
        model.addAttribute("List1", sectionList);
        model.addAttribute("tempId", Fid);
        model.addAttribute("title","Attendence for " + section.getCourse().getCourseTitle());

        return "attendanceStatus";
    }


}