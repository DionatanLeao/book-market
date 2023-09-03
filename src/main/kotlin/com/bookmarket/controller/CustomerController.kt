package com.bookmarket.controller

import com.bookmarket.controller.request.PostCustomerRequest
import com.bookmarket.model.CustomerModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController {

    @GetMapping
    fun getCustomer() = CustomerModel("1", "Customer1", "customer1@email.com")

    @PostMapping
    fun create(@RequestBody customer: PostCustomerRequest) {
        println("create ::: $customer")
    }

}