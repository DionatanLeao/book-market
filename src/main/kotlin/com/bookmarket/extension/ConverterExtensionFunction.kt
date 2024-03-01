package com.bookmarket.extension

import com.bookmarket.controller.request.PostBookRequest
import com.bookmarket.controller.request.PostCustomerRequest
import com.bookmarket.controller.request.PutBookRequest
import com.bookmarket.controller.request.PutCustomerRequest
import com.bookmarket.controller.response.BookResponse
import com.bookmarket.controller.response.CustomerResponse
import com.bookmarket.enuns.BookStatus
import com.bookmarket.enuns.CustomerStatus
import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE,
        password = this.password
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        name = this.name,
        email = this.email,
        status = previousValue.status,
        password = previousValue.password
    )
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = name,
        price = price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = name ?: previousValue.name,
        price = price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = id,
        name = name,
        email = email,
        status = status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = id,
        name = name,
        price = price,
        status = status,
        customer = customer

    )
}