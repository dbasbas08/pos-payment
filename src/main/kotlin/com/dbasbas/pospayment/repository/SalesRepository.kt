package com.dbasbas.pospayment.repository

import com.dbasbas.pospayment.dataclass.SaleResult
import java.time.LocalDateTime

interface SalesRepository {

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