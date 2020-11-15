package com.xsc.mundiagua.model.intervention

import javax.persistence.*

@Entity
data class Zone(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String,
    val color: String,
    val border: String
)