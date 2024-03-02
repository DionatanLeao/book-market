package com.bookmarket.model

import com.bookmarket.enums.CustomerStatus
import com.bookmarket.enums.Profile
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity(name = "customer")
data class CustomerModel(@Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null, @Column
    var name: String, @Column
    var email: String, @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus, @Column
    var password: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Profile::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "customer_roles", joinColumns = [JoinColumn(name = "customer_id")])
    var roles: Set<Profile> = setOf())