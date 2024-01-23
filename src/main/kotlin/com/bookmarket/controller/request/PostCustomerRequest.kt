package com.bookmarket.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty
    val name: String,
    @field:Email
    val email: String
)