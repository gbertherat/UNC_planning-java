package nc.univ.java.controller;

import nc.univ.java.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
class MainController {
    @Autowired
    private Service service;

    @GetMapping(path = "")
    public String getIndex() {
        return "index.html";
    }

    @GetMapping(path = "/test")
    public void launchTest() throws SQLException {
        service.printDatabaseDetail();
    }
}
