package nc.univ.java.controller.universite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/universite")
public class UniversiteController {
    @GetMapping(path = "")
    public String getIndex(){
        return "universite.html";
    }
}
