package fialka.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "laptop")
data class Laptop(
    @Id
    val lid: Int,
    val lname: String
)