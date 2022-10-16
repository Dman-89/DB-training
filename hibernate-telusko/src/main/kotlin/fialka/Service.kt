package fialka

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Service {

    @Autowired
    lateinit var sessionFactory: SessionFactory

    fun save() {
        val session = sessionFactory.openSession()
        session.beginTransaction()

    }

}