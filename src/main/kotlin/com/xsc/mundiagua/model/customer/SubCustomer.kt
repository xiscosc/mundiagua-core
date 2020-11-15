package com.xsc.mundiagua.model.customer

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class SubCustomer(
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
        @OneToMany(mappedBy = "subCustomer", fetch = FetchType.LAZY)
        val addresses: List<Address> = listOf(),
        @JsonIgnore
        @OneToMany(mappedBy = "subCustomer", fetch = FetchType.LAZY)
        val phones: List<Phone> = listOf(),
        @ManyToOne
        val parentCustomer: Customer?
)