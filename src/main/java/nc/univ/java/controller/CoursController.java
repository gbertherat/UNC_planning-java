package nc.univ.java.controller;

import nc.univ.java.model.Cours;
import nc.univ.java.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cours")
public class CoursController {
    @Autowired
    private Service service;

    @GetMapping(path = "")
    public String getCours(Model model){
        List<Cours> cours = service.getAllCours();
        model.addAttribute("cours", cours);
        return "cours";
    }

    @PutMapping(path = "")
    public String addCours(){
        return "add_cours";
    }

    @GetMapping(path = "/{id}")
    public String getCoursById(@PathVariable long id, Model model){
        Optional<Cours> cours = service.getCoursById(id);

        if(cours.isPresent()){
            model.addAttribute("cours", cours.get());
        } else {
            return "error";
        }
        return "coursId";
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
