package com.bookmarket.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController {

    @GetMapping
    fun helloWorld() = "Customer 1"

    @GetMapping("/2")
    fun customerTwo() = "Customer 2"
}