package fialka.contoller;

import fialka.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Controller {

    @Autowired
    private PersonRepository dbRepository;

    @GetMapping("/ping")
    public String ping() {
        return "blabla";
    }

    @PostMapping("/ping2")
    public void ping2() {

    }



}
