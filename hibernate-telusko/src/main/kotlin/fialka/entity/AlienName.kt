package fialka.entity

import jakarta.persistence.Embeddable

@Embeddable
data class AlienName(
    val fname: String,
    val lname: String,
    val mname: String,
)