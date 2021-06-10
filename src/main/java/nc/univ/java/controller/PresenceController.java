package nc.univ.java.controller;

import nc.univ.java.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/presences")
public class PresenceController {
    @Autowired
    private Service service;

    @GetMapping(path = "")
    public String getPresences(){
        service.getAllPresences().forEach(presence -> {
            System.out.println("----------------------------------");
            System.out.println(presence.getSeance().getCours().getLibelle());
            System.out.println(presence.getSeance().getDatedebut());
            System.out.println(presence.getSeance().getDatefin());
            System.out.println(presence.getEtudiant().getNom() + " " + presence.getEtudiant().getPrenom());
            System.out.println(presence.getEtudiant().getNiveau().getFormation().getLibelle());
        });
        return "index";
    }
}
