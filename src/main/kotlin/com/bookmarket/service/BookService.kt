package com.bookmarket.service

import com.bookmarket.enuns.BookStatus
import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel
import com.bookmarket.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll() =
        bookRepository.findAll().toList()
    
    fun findActives() =
        bookRepository.findByStatus(BookStatus.ACTIVE)
    
    fun findById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow()

    fun update(book: BookModel) =
        bookRepository.save(book)
    
    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELLED
        update(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        books.forEach {
            it.status = BookStatus.DELETED
        }
        bookRepository.saveAll(books)
    }

}
