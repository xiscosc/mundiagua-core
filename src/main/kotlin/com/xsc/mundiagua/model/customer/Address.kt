package com.xsc.mundiagua.model.customer

import com.xsc.mundiagua.model.intervention.Zone
import javax.persistence.*

@Entity
data class Address(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        val alias: String,
        val address: String,
        val latitude: String?,
        val longitude: String?,
        @ManyToOne
        val defaultZone: Zone?,
        @ManyToOne
        val customer: Customer?,
        @ManyToOne
        val subCustomer: SubCustomer?
)