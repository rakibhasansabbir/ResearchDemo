package bd.ac.seu.researchdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public String test(Model model){

        model.addAttribute("test","Test Karim");
        return "test";
    }
}
