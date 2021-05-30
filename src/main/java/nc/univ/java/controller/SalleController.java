package nc.univ.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/salle")
public class SalleController {
    @GetMapping(path = "")
    public String getSalles(){
        return "salles";
    }

    @PutMapping(path = "")
    public String addSalle(){
        return "add_salle";
    }

    @GetMapping(path = "/{id}")
    public String getSalleById(@PathVariable String id){
        return "salle";
    }

    @PostMapping(path = "/{id}")
    public String updateSalleById(@PathVariable String id){
        return "update_salle";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteSalleById(@PathVariable String id){
        return "delete_salle";
    }
}
