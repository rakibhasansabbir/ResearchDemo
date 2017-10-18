package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.Attendance;
import bd.ac.seu.researchdemo.Models.Teachers;
import bd.ac.seu.researchdemo.Models.course;
import bd.ac.seu.researchdemo.Models.data.AttendenceDao;
import bd.ac.seu.researchdemo.Models.data.CourseDao;
import bd.ac.seu.researchdemo.Models.data.StudentDao;
import bd.ac.seu.researchdemo.Models.data.TeachersDao;
import bd.ac.seu.researchdemo.Models.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Controller
public class CourseController {


    student st;
    @Autowired
    CourseDao courseDao;
    @Autowired
    AttendenceDao attendenceDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    TeachersDao teachersDao;
    Teachers teachers;
    course cat;
    int tempID;
    String date;
    List<student> students;
    List<Attendance> attendanceList;
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Course");
        return "login";
    }

    @RequestMapping(value = "home")
    public String index2(Model model) {
        model.addAttribute("List1", courseDao.findAll());
        model.addAttribute("title", "Course");
        return "index";
    }

//    @RequestMapping(value = "student",method = RequestMethod.GET)
//    public String showStudent(Model model){
//
//       students = cat.getStudents();
//        model.addAttribute("title",  cat.getCoursetitle());
//
//        model.addAttribute("List1", students);
//
//
//        return "student";
//    }

    @RequestMapping(value = "classmates",method = RequestMethod.GET)
    public String showStudent(Model model, @RequestParam int id) {

        tempID= id;
        cat = courseDao.findOne(id);

        students = cat.getStudents();
        model.addAttribute("List3", students);
        model.addAttribute("List1", courseDao.findAll());
        model.addAttribute("title",  "Student of: "+cat.getCoursetitle());
        return "classmates";

    }

    @RequestMapping(value = "classmates1",method = RequestMethod.GET)
    public String showStudent(Model model) {

        cat = courseDao.findOne(tempID);
        students = cat.getStudents();
        model.addAttribute("List3", students);
        model.addAttribute("List1", courseDao.findAll());
        model.addAttribute("title",  "Student of: "+cat.getCoursetitle());
        return "classmates";

    }


    @RequestMapping(value = "stream",method = RequestMethod.GET)
    public String stream(Model model){
        cat = courseDao.findOne(tempID);
        teachers = teachersDao.findOne(tempID);
        model.addAttribute("title",  cat.getCoursetitle());

        model.addAttribute("List1", courseDao.findAll());
       model.addAttribute("title1",  teachers.getTeacherName());
        return "stream";
    }
    @RequestMapping(value = "about",method = RequestMethod.GET)
    public String about(Model model){
        cat = courseDao.findOne(tempID);
        teachers = teachersDao.findOne(tempID);
        students = cat.getStudents();
        model.addAttribute("List3", students);
        model.addAttribute("title",  cat.getCoursetitle());
        model.addAttribute("List1", courseDao.findAll());
        model.addAttribute("title1",  teachers.getTeacherName());   
        return "about";
    }

    @RequestMapping(value = "attendance",method = RequestMethod.GET)
    public String attendence(Model model,@RequestParam String bday) {
        date = bday;
        cat = courseDao.findOne(tempID);
        teachers = teachersDao.findOne(tempID);
        students = cat.getStudents();
        model.addAttribute("List6", students);
        model.addAttribute("title", cat.getCoursetitle());
        model.addAttribute("title1",  teachers.getTeacherName());
        model.addAttribute("title3",  "Attendence for: "+bday);
        model.addAttribute("List1", courseDao.findAll());

        return "attendance";
    }
    @RequestMapping(value = "attendance",method = RequestMethod.POST)
    public String postattendence(Model model, @RequestParam int[] Ids,
                                 @ModelAttribute @Valid Attendance attendance,
                                 Errors errors
                                        ) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Add To List");
            model.addAttribute("categories",attendenceDao.findAll() );
            return "attendance";
        }


        for (int id : Ids) {
            course cat =courseDao.findOne(id);
            attendance.setCourse(cat);

            attendance.setDate(date);

            Teachers teachers = teachersDao.findOne(id);
            attendance.setTeachers(teachers);

            student s = studentDao.findOne(id);
            attendance.setStudent(s);
            attendenceDao.save(attendance);
        }





        return "redirect:";
    }


}
