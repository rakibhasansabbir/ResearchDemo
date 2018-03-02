package bd.ac.seu.researchdemo.Controller;

import bd.ac.seu.researchdemo.Models.TestUpload;
import bd.ac.seu.researchdemo.repository.TestUploadDao;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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



    @PostMapping(value = "/test")
    public String upload(@RequestParam MultipartFile upl) {
        try {
            TestUpload testUpload = new TestUpload(upl.getBytes());
            testUploadDao.save(testUpload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:test";
    }

    @RequestMapping(value = "/image/{image_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") int imageId) throws IOException {

        byte[] imageContent = testUploadDao.findOne(imageId).getFile();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }

}
