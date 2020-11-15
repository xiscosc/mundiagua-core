package com.xsc.mundiagua.controller.dto.customer

import com.xsc.mundiagua.controller.dto.Dto
import com.xsc.mundiagua.model.customer.Phone

data class PhoneUpdateDto(
        val alias: String?,
        val countryCode: Int?,
        val phoneNumber: Int?
): Dto<Phone>()