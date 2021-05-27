package nc.univ.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MainController {
    @GetMapping(path = "/")
    public String getIndex(){
        return "index.html";
    }
}
