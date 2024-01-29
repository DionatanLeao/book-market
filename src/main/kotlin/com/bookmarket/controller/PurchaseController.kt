package com.bookmarket.controller

import com.bookmarket.controller.request.PostPurchaseRequest
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchases")
class PurchaseController {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody request: PostPurchaseRequest) {

    }
}