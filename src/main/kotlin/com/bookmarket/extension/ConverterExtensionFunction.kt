package com.bookmarket.extension

import com.bookmarket.controller.request.PostBookRequest
import com.bookmarket.controller.request.PostCustomerRequest
import com.bookmarket.controller.request.PutCustomerRequest
import com.bookmarket.enuns.BookStatus
import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(name = name, price = price, status = BookStatus.ACTIVE, customer = customer)
}