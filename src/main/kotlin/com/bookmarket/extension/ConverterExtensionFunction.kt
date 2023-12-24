package com.bookmarket.extension

import com.bookmarket.controller.request.PostCustomerRequest
import com.bookmarket.controller.request.PutCustomerRequest
import com.bookmarket.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}