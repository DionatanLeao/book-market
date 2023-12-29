package com.bookmarket.service

import com.bookmarket.model.BookModel
import com.bookmarket.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}
