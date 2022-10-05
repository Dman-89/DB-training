package fialka.repository;

import fialka.config.HibernateUtil;
import fialka.entity.Person;
import fialka.utils.Gender;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;


@Repository
//public interface DBRepository extends JpaRepository<Person, Long> {
public class DBRepositoryImpl implements DBRepository {

//    @PersistenceContext
//    EntityManager entityManager;

    @Transactional
    public boolean insertToDB(Person person) {
//        Transaction transaction = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//        HibernateUtil.getSessionFactory().createEntityManager().createNativeQuery("INSERT INTO Person (id, first_name, last_name, gender) VALUES (?,?,?,?)")
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
        em.getTransaction().begin();
//        HibernateUtil.getSessionFactory().getCurrentSession().createNativeQuery("INSERT INTO Person (id, first_name, last_name, gender) VALUES (?,?,?,?)")
        em.createNativeQuery("INSERT INTO Person (personid, firstname, lastname, gender) VALUES (?,?,?,cast(? as gender))")
                .setParameter(1, person.getId())
                .setParameter(2, person.getFirstName())
                .setParameter(3, person.getLastName())
                .setParameter(4, person.getGender().toString())
                .executeUpdate();
//        transaction.commit();
        em.getTransaction().commit();

        return true;
    }

}
