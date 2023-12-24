package com.bookmarket.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Column

@Entity(name = "customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null,
    @Column
    var name: String,
    @Column
    var email: String
)