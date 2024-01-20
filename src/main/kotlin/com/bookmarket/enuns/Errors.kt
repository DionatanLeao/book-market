package com.bookmarket.enuns

enum class Errors(
    val code: String,
    val message: String
) {

    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot change a book with the status [%s]"),
    ML201("ML-201", "Customer [%s] not exists")
}