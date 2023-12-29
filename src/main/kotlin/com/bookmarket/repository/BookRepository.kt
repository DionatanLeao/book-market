package com.bookmarket.repository

import com.bookmarket.model.BookModel
import com.bookmarket.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int>