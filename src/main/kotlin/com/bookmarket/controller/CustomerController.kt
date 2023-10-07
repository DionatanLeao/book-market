package com.bookmarket.controller

import com.bookmarket.controller.request.PostCustomerRequest
import com.bookmarket.model.CustomerModel
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getCustomer() = customers

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String) = customers.filter { it.id == id }.first()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()
        customers.add(CustomerModel(id, customer.name, customer.email))
    }

}