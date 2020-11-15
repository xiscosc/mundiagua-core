package com.xsc.mundiagua.controller.dto.customer

import com.xsc.mundiagua.controller.dto.Dto
import com.xsc.mundiagua.model.customer.Customer

data class CustomerUpdateDto(
        val name: String?,
        val internalCode: String?,
        val nationalId: String?,
        val payMethod: String?,
        val comments: String?,
        val blocked: Boolean?,
        val emails: List<String>?
): Dto<Customer>()
