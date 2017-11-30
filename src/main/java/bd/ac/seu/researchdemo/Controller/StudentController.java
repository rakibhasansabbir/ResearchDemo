package bd.ac.seu.researchdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping("test")
    private String home(@RequestParam(required = false) Integer id){

        return "test";
    }
}
