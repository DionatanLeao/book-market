package com.bookmarket.controller.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class PostPurchaseRequest(
    @field:NotNull
    @field:Positive
    val customerId: Int,
    @field:NotNull
    val bookIds: Set<Int>
)