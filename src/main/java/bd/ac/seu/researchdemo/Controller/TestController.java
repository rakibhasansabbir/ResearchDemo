package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.TestUpload;
import bd.ac.seu.researchdemo.repository.TestUploadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class TestController {

    @Autowired
    TestUploadDao testUploadDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model){

        model.addAttribute(new TestUpload());
        model.addAttribute("fileList",testUploadDao.findAll());
        return "test";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String upload(@ModelAttribute @Valid TestUpload testUpload){
        testUploadDao.save(new TestUpload(testUpload.getFile()));
        return "redirect:test";
    }
}
