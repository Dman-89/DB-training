package fialka.repository;

import fialka.utils.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DBRepository {

    @PersistenceContext
    EntityManager entityManager;

    public boolean insertToDB(String name, int age, Gender gender) {
        entityManager.g

        return true;
    }

}
