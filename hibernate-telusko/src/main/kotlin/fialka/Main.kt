package fialka

import fialka.entity.Laptop
import fialka.entity.Student


fun main() {
    val session = HibernateUtil.sessionFactory.openSession()
    session.beginTransaction()

    val laptop = Laptop(1, "Dell")
    val student = Student(101, "Navin", 56, laptop)

    session.persist(student)

    println(session.get(Student::class.java, 101))

    session.close()
}

class Main {
}