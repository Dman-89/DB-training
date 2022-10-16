package fialka.entity

import jakarta.persistence.*

@Entity
@Table(name = "alien")
data class Alien(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: AlienName,
    val color: String,
    @Transient
    val dummyVal: String = "blabla"
)

