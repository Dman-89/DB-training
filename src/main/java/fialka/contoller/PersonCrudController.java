package fialka.contoller;

import fialka.contoller.exception.PersonNotFoundException;
import fialka.contoller.model.PersonDTO;
import fialka.entity.PersonEntity;
import fialka.service.PersonService;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonCrudController {

    private PersonService personService;

    public PersonCrudController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{personId}")
    public PersonDTO getPerson(
            @PathVariable("personId") Long personId
    ) {
        PersonEntity person = personService.getPerson(personId);
        if (person == null) throw new PersonNotFoundException();
        return toPersonDTO(person);
    }
    @PostMapping("/person")
    public PersonDTO createPerson(
            @RequestBody PersonDTO personDTO
    ) {
        PersonEntity person = toPerson(null, personDTO);
        PersonEntity savedPerson = personService.createPerson(person);
        return toPersonDTO(savedPerson);
    }

    private PersonDTO toPersonDTO(PersonEntity person) {
        return new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getGender()
        );
    }

    private PersonEntity toPerson(Long personId, PersonDTO personDTO) {
        return new PersonEntity(
                personId,
                personDTO.getFirstName(),
                personDTO.getLastName(),
                personDTO.getGender()
        );

    }
}
