package fialka.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "student")
data class Student(
    @Id
    val rollno: Int,
    val name: String,
    val marks: Int,
    @OneToOne
    val laptop: Laptop
)