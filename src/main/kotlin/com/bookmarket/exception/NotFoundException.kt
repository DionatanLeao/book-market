package com.bookmarket.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}