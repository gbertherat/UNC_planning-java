package nc.univ.java.controller.salle;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/universite/salle")
public class SalleController {
    @GetMapping(path = "")
    public String getSalles(){
        return "salles.html";
    }

    @PutMapping(path = "")
    public String addSalle(){
        return "add_salle.html";
    }

    @GetMapping(path = "/{id}")
    public String getSalleById(@PathVariable String id){
        return "salle_"+ id +".html";
    }

    @PostMapping(path = "/{id}")
    public String updateSalleById(@PathVariable String id){
        return "update_salle_"+ id +".html";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteSalleById(@PathVariable String id){
        return "delete_salle_"+ id +".html";
    }
}
