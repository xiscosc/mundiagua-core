package com.xsc.mundiagua.repository.customer

import com.xsc.mundiagua.model.customer.Customer
import org.springframework.data.repository.PagingAndSortingRepository

interface CustomerRepository : PagingAndSortingRepository<Customer?, Long?> {
    fun findByName(name: String?): List<Customer?>?
}