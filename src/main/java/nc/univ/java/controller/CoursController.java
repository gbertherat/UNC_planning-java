package nc.univ.java.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/universite/cours")
public class CoursController {
    @GetMapping(path = "")
    public String getCours(){
        return "cours.html";
    }

    @PutMapping(path = "")
    public String addCours(){
        return "add_cours.html";
    }

    @GetMapping(path = "/{id}")
    public String getCoursById(@PathVariable String id){
        return "cours_"+ id +".html";
    }

    @PostMapping(path = "/{id}")
    public String updateCoursById(@PathVariable String id){
        return "update_cours_"+ id +".html";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCoursById(@PathVariable String id){
        return "delete_cours_"+ id +".html";
    }
}
