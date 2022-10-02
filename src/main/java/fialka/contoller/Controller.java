package fialka.contoller;

import fialka.entity.Person;
import fialka.repository.DBRepository;
import fialka.utils.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Controller {

    @Autowired
    private DBRepository dbRepository;

    private static ResponseEntity okResponse = new ResponseEntity(HttpStatus.OK);

    @GetMapping("/ping")
    public ResponseEntity ping() {
        return new ResponseEntity<String>("blabla", HttpStatus.OK);
    }

    @PostMapping("/ping2")
    public ResponseEntity ping2() {
        return okResponse;
    }

    @PostMapping("/insertToDb")
    public ResponseEntity insertToDb() {
        dbRepository.insertToDB(new Person("Gurbanguly", "Berdymukhamedov", Gender.Male));
        return okResponse;
    }

}
