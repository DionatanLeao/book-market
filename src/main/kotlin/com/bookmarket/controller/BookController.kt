package com.bookmarket.controller

import com.bookmarket.controller.request.PostBookRequest
import com.bookmarket.controller.request.PutBookRequest
import com.bookmarket.extension.toBookModel
import com.bookmarket.service.BookService
import com.bookmarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val customerService: CustomerService,
    val bookService: BookService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        bookService.create(request.toBookModel(customerService.findById(request.customerId)))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll() =
        bookService.findAll()

    @GetMapping("/active")
    @ResponseStatus(HttpStatus.OK)
    fun findActives() =
        bookService.findActives()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id: Int) =
        bookService.findById(id)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved = bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }
}