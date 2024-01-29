package com.bookmarket.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table
data class PurchaseModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerModel,
    @ManyToMany
    @JoinTable(name = "purchase_book",
        joinColumns = [JoinColumn(name = "purchase_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")])
    val books: List<BookModel>,
    @Column
    val nfe: String,
    @Column
    val price: BigDecimal,
    @Column(name = "created_at")
    val createdAt: LocalDateTime
)