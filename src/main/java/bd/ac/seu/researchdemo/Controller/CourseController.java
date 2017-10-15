package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.Teachers;
import bd.ac.seu.researchdemo.Models.course;
import bd.ac.seu.researchdemo.Models.data.CourseDao;
import bd.ac.seu.researchdemo.Models.data.StudentDao;
import bd.ac.seu.researchdemo.Models.data.TeachersDao;
import bd.ac.seu.researchdemo.Models.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseDao courseDao;
    @Autowired
    TeachersDao teachersDao;
    Teachers teachers;
    course cat;
    int tempID;
    List<student> students;
    @RequestMapping(value = "")
    public String index(Model model) {
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
        model.addAttribute("title",  cat.getCoursetitle());
        model.addAttribute("List1", courseDao.findAll());
        model.addAttribute("title1",  teachers.getTeacherName());   
        return "about";
    }



}
