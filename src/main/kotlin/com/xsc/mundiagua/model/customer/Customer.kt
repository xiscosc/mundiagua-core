package com.xsc.mundiagua.model.customer

import com.fasterxml.jackson.annotation.JsonIgnore
import com.xsc.mundiagua.model.Model
import javax.persistence.*
import javax.persistence.GenerationType

import javax.persistence.GeneratedValue

@Entity
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        val name: String,
        val internalCode: String?,
        val nationalId: String?,
        val payMethod: String?,
        val comments: String?,
        val blocked: Boolean,
        @ElementCollection
        val emails: List<String>,
        @JsonIgnore
        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
        val addresses: List<Address> = listOf(),
        @JsonIgnore
        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
        val phones: List<Phone> = listOf(),
        @JsonIgnore
        @OneToMany(mappedBy = "parentCustomer", fetch = FetchType.LAZY)
        val subCustomers: List<SubCustomer> = listOf()
): Model

