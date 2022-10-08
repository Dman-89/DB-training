package fialka.service;

import fialka.entity.PersonEntity;
import fialka.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity createPerson(PersonEntity personEntity) {
        return personRepository.save(personEntity);
    }

    public PersonEntity getPerson(Long personId) {
        return personRepository.findById(personId).orElse(null);
    }
}
