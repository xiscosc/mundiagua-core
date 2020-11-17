package com.xsc.mundiagua.controller.v1

import com.xsc.mundiagua.controller.dto.customer.CustomerUpdateDto
import com.xsc.mundiagua.controller.dto.customer.PhoneUpdateDto
import com.xsc.mundiagua.model.customer.Customer
import com.xsc.mundiagua.model.customer.Phone
import com.xsc.mundiagua.service.CustomerService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/v1/customer"], produces = [MediaType.APPLICATION_JSON_VALUE])
class CustomerControllerV1(val customerService: CustomerService) {

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable("id") id: Int): Customer? {
        return customerService.getCustomerById(id)
    }

    @GetMapping
    fun getAllCustomers(@RequestParam("page") page: Int, @RequestParam("limit") limit: Int): Iterable<Customer?> {
        return customerService.getAllCustomers(page, limit)
    }

    @PatchMapping("/{id}")
    fun updateCustomer(@PathVariable("id") id: Int, @RequestBody customerUpdateDto: CustomerUpdateDto): Customer? {
        return customerService.updateCustomer(id, customerUpdateDto)
    }

    @PostMapping
    fun saveCustomer(@RequestBody customer: Customer): Customer? {
        return customerService.saveCustomer(customer)
    }

    @PostMapping("/{customerId}/phone")
    fun saveCustomerPhone(@PathVariable("customerId") customerId: Int, @RequestBody phone : Phone): Phone? {
        return customerService.saveCustomerPhone(customerId, phone)
    }

    @PatchMapping("/{customerId}/phone/{phoneId}")
    fun updateCustomerPhone(
            @PathVariable("customerId") customerId: Int,
            @PathVariable("phoneId") phoneId: Int,
            @RequestBody phoneUpdateDto: PhoneUpdateDto
    ): Phone? {
        return customerService.updateCustomerPhone(customerId, phoneId, phoneUpdateDto)
    }

    @GetMapping("/{customerId}/phone/{phoneId}")
    fun getCustomerPhone(@PathVariable("customerId") customerId: Int, @PathVariable("phoneId") phoneId: Int): Phone? {
        return customerService.getCustomerPhone(customerId, phoneId)
    }

    @GetMapping("/{customerId}/phone")
    fun getCustomerPhones(@PathVariable("customerId") customerId: Int): Iterable<Phone?> {
        return customerService.getCustomerPhones(customerId)
    }
}