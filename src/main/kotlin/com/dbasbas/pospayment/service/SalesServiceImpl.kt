package com.dbasbas.pospayment.service

import com.dbasbas.pospayment.dataclass.SaleResult
import com.dbasbas.pospayment.repository.SalesRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class SalesServiceImpl(val salesRepository: SalesRepository) : SalesService {

    @Transactional
    override fun sales(
        startDateTime: String,
        endDateTime: String
    ): List<SaleResult> {
        return salesRepository.sales(
            startDateTime = startDateTime,
            endDateTime = endDateTime
        )
    }

    @Transactional
    override fun createPayment(
        final_price: Double,
        price_modifier: Double,
        points: Int,
        payment_method: String,
        datetime: LocalDateTime
    ) {
        return salesRepository.createPayment(
            final_price = final_price,
            price_modifier = price_modifier,
            points = points,
            payment_method = payment_method,
            datetime = datetime)
    }

}