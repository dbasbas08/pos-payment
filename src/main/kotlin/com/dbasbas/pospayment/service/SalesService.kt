package com.dbasbas.pospayment.service

import com.dbasbas.pospayment.dataclass.SaleResult
import java.time.LocalDateTime

interface SalesService {

    fun sales(
        startDateTime: String,
        endDateTime: String
    ): List<SaleResult>

    fun createPayment(
        final_price: Double,
        price_modifier: Double,
        points: Int,
        payment_method: String,
        datetime: LocalDateTime
    )
}