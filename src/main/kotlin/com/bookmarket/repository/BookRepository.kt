package com.bookmarket.repository

import com.bookmarket.enuns.BookStatus
import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>
}