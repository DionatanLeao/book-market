package com.bookmarket.service

import com.bookmarket.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter {
                it.name.contains(name, ignoreCase = true)
            }
        }
        return customers
    }

    fun create(customer: CustomerModel) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()
        customer.id = id
        customers.add(customer)
    }

    fun getCustomer(id: String?): List<CustomerModel> {
        id?.let {
            return customers.filter { it.id!!.contains(id, true) }
        }
        return customers
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.filter { it.id == id }.first().let {
            customers.remove(it)
        }
    }
}