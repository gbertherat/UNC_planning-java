package nc.univ.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/cours")
public class CoursController {
    @GetMapping(path = "")
    public String getCours(){
        return "cours";
    }

    @PutMapping(path = "")
    public String addCours(){
        return "add_cours";
    }

    @GetMapping(path = "/{id}")
    public String getCoursById(@PathVariable String id){
        return "cour";
    }

    @PostMapping(path = "/{id}")
    public String updateCoursById(@PathVariable String id){
        return "update_cours";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCoursById(@PathVariable String id){
        return "delete_cours";
    }
}
