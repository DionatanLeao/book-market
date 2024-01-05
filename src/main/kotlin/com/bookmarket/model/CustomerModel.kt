package com.bookmarket.model

import com.bookmarket.enuns.CustomerStatus
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity(name = "customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var email: String,
    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus
)