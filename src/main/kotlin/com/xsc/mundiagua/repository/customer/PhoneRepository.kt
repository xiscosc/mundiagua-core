package com.xsc.mundiagua.repository.customer

import com.xsc.mundiagua.model.customer.Phone
import org.springframework.data.repository.CrudRepository

interface PhoneRepository: CrudRepository<Phone?, Long?> {
    fun findByCustomerIdAndId(customerId: Long, id: Long): Phone?

    fun findAllByCustomerId(customerId: Long): Iterable<Phone?>
}