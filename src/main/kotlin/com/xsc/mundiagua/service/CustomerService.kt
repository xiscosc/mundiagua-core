package com.xsc.mundiagua.service

import com.xsc.mundiagua.controller.dto.customer.CustomerUpdateDto
import com.xsc.mundiagua.controller.dto.customer.PhoneUpdateDto
import com.xsc.mundiagua.model.customer.Customer
import com.xsc.mundiagua.model.customer.Phone
import com.xsc.mundiagua.repository.customer.CustomerRepository
import com.xsc.mundiagua.repository.customer.PhoneRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Service
class CustomerService(
        val customerRepository: CustomerRepository,
        val phoneRepository: PhoneRepository,
        val entityManager: EntityManager
) {

    fun saveCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun getCustomerById(id: Int): Customer? {
        return customerRepository.findById(id.toLong()).orElse(null)
    }

    @Transactional
    fun updateCustomer(id: Int, customerDto: CustomerUpdateDto): Customer? {
        val currentCustomer = getCustomerById(id) ?: return null
        val updatedCustomer = customerDto.partialUpdate(currentCustomer)
        return saveCustomer(updatedCustomer)
    }

    fun getAllCustomers(page: Int, limit: Int): Iterable<Customer?> {
        return customerRepository.findAll(PageRequest.of(page, limit))
    }

    fun saveCustomerPhone(customerId: Int, phone: Phone): Phone? {
        val customerReference = entityManager.getReference(Customer::class.java, customerId.toLong())
        return phoneRepository.save(phone.copy(customer = customerReference, subCustomer = null))
    }

    fun getCustomerPhone(customerId: Int, phoneId: Int): Phone? {
        return phoneRepository.findByCustomerIdAndId(customerId.toLong(), phoneId.toLong())
    }

    @Transactional
    fun updateCustomerPhone(customerId: Int, phoneId: Int, phoneUpdateDto: PhoneUpdateDto): Phone? {
        val currentPhone = getCustomerPhone(customerId, phoneId) ?: return null
        val updatedPhone = phoneUpdateDto.partialUpdate(currentPhone)
        return phoneRepository.save(updatedPhone)
    }

    fun getCustomerPhones(customerId: Int): Iterable<Phone?> {
        return phoneRepository.findAllByCustomerId(customerId.toLong())
    }
}