package com.bookmarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class BookMarketApplication

fun main(args: Array<String>) {
	runApplication<BookMarketApplication>(*args)
}
