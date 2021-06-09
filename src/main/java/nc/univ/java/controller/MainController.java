package nc.univ.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class MainController {
    @GetMapping(path = "")
    public String getIndex() {
        return "index";
    }

    @GetMapping(path = "/error")
    public String error() {
        return "error";
    }
}
