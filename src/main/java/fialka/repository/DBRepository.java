package fialka.repository;

import fialka.entity.Person;

public interface DBRepository {
    boolean insertToDB(Person person);
}
