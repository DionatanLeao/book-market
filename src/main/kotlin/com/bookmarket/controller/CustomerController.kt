package com.bookmarket.controller

import com.bookmarket.model.CustomerModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController {

    @GetMapping
    fun customer() = CustomerModel("1", "Customer1", "customer1@email.com")
}