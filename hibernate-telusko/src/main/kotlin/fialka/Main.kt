package fialka

import fialka.entity.Laptop
import fialka.entity.Student


fun main() {

    val session = HibernateUtil.sessionFactory.openSession()
    val transaction = session.beginTransaction()

    val laptop1 = Laptop(1, "Dell")
    val laptop2 = Laptop(2, "HP")
    val student = Student(101, "Navin", 56, listOf(laptop1, laptop2))

    laptop1.stud = student
    laptop2.stud = student

    session.persist(student)
    session.persist(laptop1)
    session.persist(laptop2)

    println(session.get(Student::class.java, 101))
    println(session.get(Laptop::class.java, 1))
    println(session.get(Student::class.java, 2))

    transaction.commit()

    session.close()
}

class Main {
}