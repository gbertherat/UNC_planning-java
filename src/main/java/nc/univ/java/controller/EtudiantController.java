package nc.univ.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/etudiant")
public class EtudiantController {
    @GetMapping(path = "")
    public String getEtudiants(){
        return "etudiants";
    }

    @PutMapping(path = "")
    public String addEtudiant(){
        return "add_etudiant";
    }

    @GetMapping(path = "/{id}")
    public String getEtudiantById(@PathVariable String id){
        return "etudiant";
    }

    @PostMapping(path = "/{id}")
    public String updateEtudiantById(@PathVariable String id){
        return "update_etudiant";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteEtudiantById(@PathVariable String id){
        return "delete_etudiant";
    }
}
