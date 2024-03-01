package com.bookmarket.service

import com.bookmarket.enuns.BookStatus
import com.bookmarket.enuns.Errors
import com.bookmarket.exception.NotFoundException
import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel
import com.bookmarket.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> =
        bookRepository.findAll(pageable)
    
    fun findActives(pageable: Pageable) =
        bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
    
    fun findById(id: Int): BookModel =
        bookRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }

    fun findAllByIds(bookIds: Set<Int>): List<BookModel> {
        return bookRepository.findAllById(bookIds).toList()
    }

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

    fun purchase(books: MutableList<BookModel>) {
        books.map {
            it.status = BookStatus.SOLD
        }
        bookRepository.saveAll(books)
    }

}
