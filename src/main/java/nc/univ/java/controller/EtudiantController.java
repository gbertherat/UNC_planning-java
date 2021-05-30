package nc.univ.java.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/etudiant")
public class EtudiantController {
    @GetMapping(path = "")
    public String getEtudiants(){
        return "etudiants.html";
    }

    @PutMapping(path = "")
    public String addEtudiant(){
        return "add_etudiant.html";
    }

    @GetMapping(path = "/{id}")
    public String getEtudiantById(@PathVariable String id){
        return "etudiant_"+ id +".html";
    }

    @PostMapping(path = "/{id}")
    public String updateEtudiantById(@PathVariable String id){
        return "update_etudiant_"+ id +".html";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteEtudiantById(@PathVariable String id){
        return "delete_etudiant_"+ id +".html";
    }
}
