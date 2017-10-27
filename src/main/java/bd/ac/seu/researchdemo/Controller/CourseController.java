package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.Faculty;
import bd.ac.seu.researchdemo.Models.Section;
import bd.ac.seu.researchdemo.Service.FacultyDao;
import bd.ac.seu.researchdemo.Service.SectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    @Autowired
    FacultyDao facultyDao;
    @Autowired
    SectionDao sectionDao;
    String a;

    Faculty faculty;

   @RequestMapping(value = "/")
    public String login(){
        return"login";
    }


    @RequestMapping(value = "home",method = RequestMethod.GET)
    private String home(Model model, @RequestParam int id){
        Faculty faculty;
        faculty = facultyDao.findOne(id);
        Section section = sectionDao.findOne(1);

        if (faculty.getFacultyId() == (section.getFaculty().getFacultyId())){
            model.addAttribute("title",faculty.getFacultyName());
            model.addAttribute("List1",sectionDao.findAll());

        }
        else {
            model.addAttribute("title","You have not registered any course in this semester");
        }
        return "index";
    }
}
