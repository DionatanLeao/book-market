package com.bookmarket.service

import com.bookmarket.model.CustomerModel
import com.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }




    fun create(customer: CustomerModel) =
        customerRepository.save(customer)

    fun getCustomer(id: Int): CustomerModel =
        customerRepository.findById(id).orElseThrow()

    fun update(customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if(!customerRepository.existsById(id)) {
            throw Exception()
        }
        customerRepository.deleteById(id)
    }
}