package nc.univ.java.controller;

import nc.univ.java.model.Etudiant;
import nc.univ.java.model.Niveau;
import nc.univ.java.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/etudiants")
public class EtudiantController {
    @Autowired
    private Service service;

    @GetMapping(path = "")
    public String getEtudiants(Model model) throws SQLException {
        List<Etudiant> etudiants = service.getAllEtudiants();
        model.addAttribute("etudiants", etudiants);
        return "etudiants";
    }

    @PutMapping(path = "")
    public String addEtudiant(){
        return "add_etudiant";
    }

    @GetMapping(path = "/{id}")
    public String getEtudiantById(@PathVariable long id, Model model){
        Optional<Etudiant> etudiant = service.getEtudiantById(id);
        Optional<Niveau> niveau = service.getNiveauOfEtudiant(id);

        if(etudiant.isPresent() && niveau.isPresent()){
            model.addAttribute("etudiant", etudiant.get());
            model.addAttribute("niveau", niveau.get());
        } else {
            return "error";
        }
        return "etudiantsId";
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
