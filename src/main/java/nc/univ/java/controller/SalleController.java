package nc.univ.java.controller;

import nc.univ.java.model.Salle;
import nc.univ.java.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/salle")
public class SalleController {
    @Autowired
    private Service service;

    @GetMapping(path = "")
    public String getSalles(Model model){
        List<Salle> salles = service.getAllSalles();
        model.addAttribute("salles", salles);
        return "salles";
    }

    @PutMapping(path = "")
    public String addSalle(){
        return "add_salle";
    }

    @GetMapping(path = "/{id}")
    public String getSalleById(@PathVariable long id, Model model){
        Optional<Salle> salle = service.getSalleById(id);

        if(salle.isPresent()) {
            model.addAttribute("salle", salle.get());
        } else {
            return "error";
        }
        return "sallesId";
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
