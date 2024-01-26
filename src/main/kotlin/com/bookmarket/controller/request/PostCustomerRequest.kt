package com.bookmarket.controller.request

import com.bookmarket.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Name must be informed")
    val name: String,
    @field:Email(message = "Email must be valid")
    @EmailAvailable
    val email: String
)