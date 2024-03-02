package com.bookmarket.controller.response

import com.bookmarket.enums.BookStatus
import com.bookmarket.model.CustomerModel
import java.math.BigDecimal

data class BookResponse (
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var status: BookStatus? = null,
    var customer: CustomerModel? = null
)
