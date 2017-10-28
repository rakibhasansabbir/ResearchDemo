package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.Faculty;
import bd.ac.seu.researchdemo.Models.Registration;
import bd.ac.seu.researchdemo.Models.Section;
import bd.ac.seu.researchdemo.data.FacultyDao;
import bd.ac.seu.researchdemo.data.RegistrationDao;
import bd.ac.seu.researchdemo.data.SectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    FacultyDao facultyDao;
    @Autowired
    SectionDao sectionDao;
    @Autowired
    RegistrationDao registrationDao;
    String a;
    int temId;

    Faculty faculty;
    Section section;

   @RequestMapping(value = "/")
    public String login(){
        return"login";
    }


    @RequestMapping(value = "home",method = RequestMethod.GET)
    private String home(Model model, @RequestParam int id){
        section = sectionDao.findOne(id);
        faculty = facultyDao.findOne(id);
        List<Faculty> facultyList = facultyDao.findByFacultyId(id);
        List<Section> sectionList = sectionDao.findByFacultyFacultyId(id);
        if (facultyList.size() > 0){
            model.addAttribute("title",faculty.getFacultyName());
            model.addAttribute("List1",sectionList);

        }
        else {
            model.addAttribute("title","You have not registered any course in this semester");
        }
        return "index";
    }

    @RequestMapping(value = "stream",method = RequestMethod.GET)
    private String stream(Model model, @RequestParam int ids){

        temId = ids;
        model.addAttribute("title",faculty.getFacultyName());
        return "stream";
    }

    @RequestMapping(value = "stream1")
    private String homeStream(Model model){
        model.addAttribute("title",faculty.getFacultyName());
        return "stream";
    }

    @RequestMapping(value = "classmates1")
    private String homeClassmate(Model model){
        List<Registration> registrationList = registrationDao.findBySectionSection(temId);
        model.addAttribute("title",faculty.getFacultyName());
        model.addAttribute("List3",registrationList);
        return "classmates";
    }

    @RequestMapping(value = "about")
    private String homeAbout(Model model){
        model.addAttribute("title",faculty.getFacultyName());
        return "about";
    }

}
