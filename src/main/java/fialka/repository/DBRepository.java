package fialka.repository;

import fialka.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class DBRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public boolean insertToDB(Person person) {
        entityManager.createNativeQuery("INSERT INTO Person (id, first_name, last_name, gender) VALUES (?,?,?,?)")
                .setParameter(1, person.getId())
                .setParameter(2, person.getFirstName())
                .setParameter(3, person.getLastName())
                .setParameter(3, person.getGender())
                .executeUpdate();

        return true;
    }

}
