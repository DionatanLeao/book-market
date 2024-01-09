package com.bookmarket.repository

import com.bookmarket.enuns.BookStatus
import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository : JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
//    fun findAll(pageable: Pageable): Page<BookModel>
}