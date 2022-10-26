package fialka.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
data class Student(
    @Id
    val rollno: Int,
    val name: String,
    val marks: Int,
    // each annotation like this by default tells Hibernate to create a mapping in DB
    // if mapping goes from this entity, the extra table Student_Laptop would be created
    // but instead we want ti add just one more column to Laptop table - it's cheaper to store than a separate table
    @OneToMany(mappedBy = "stud") // mappedBy needed for hibernate not to create extra mapping table
    val laptops: List<Laptop>
)