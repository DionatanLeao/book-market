package com.bookmarket.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Name must be informed")
    val name: String,
    @field:Email(message = "Email must be valid")
    val email: String
)