package com.bookmarket.repository

import com.bookmarket.model.PurchaseModel
import org.springframework.data.repository.CrudRepository

interface PurchaseRepository : CrudRepository<PurchaseModel, Int> {
}