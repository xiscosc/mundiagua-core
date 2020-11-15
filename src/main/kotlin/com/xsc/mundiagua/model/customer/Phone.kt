package com.xsc.mundiagua.model.customer

import javax.persistence.*

@Entity
data class Phone(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        val alias: String,
        val countryCode: Int,
        val phoneNumber: Int,
        @ManyToOne
        val customer: Customer?,
        @ManyToOne
        val subCustomer: SubCustomer?
)