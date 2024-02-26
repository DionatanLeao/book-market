package com.bookmarket.events

import com.bookmarket.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
    source: Any,
    val purchaseModel: PurchaseModel
) : ApplicationEvent(source)