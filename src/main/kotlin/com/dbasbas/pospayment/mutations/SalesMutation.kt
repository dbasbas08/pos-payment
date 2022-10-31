package com.dbasbas.pospayment.mutations

import com.dbasbas.pospayment.dataclass.CreatePaymentResult
import com.dbasbas.pospayment.service.SalesService
import com.dbasbas.pospayment.util.PaymentMethod
import com.expediagroup.graphql.server.operations.Mutation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit


@Component
class SalesMutation : Mutation {

    @Autowired
    lateinit var salesService: SalesService

    fun createPayment(
        price: String,
        price_modifier: Double,
        payment_method: PaymentMethod,
        datetime: String
    ): CreatePaymentResult {
        return try {
            val initialPrice = price.toDouble()

            val finaPrice = initialPrice * price_modifier
            val points = initialPrice * payment_method.pointsMultiplier

            val minFinalPrice = initialPrice * payment_method.priceMinMultiplier
            val maxFinalPrice = initialPrice * payment_method.priceMaxMultiplier

            if (finaPrice < minFinalPrice || finaPrice > maxFinalPrice) {
                throw Error("Please adjust your price_modifier, final price should be from " +
                    "${String.format("%.2f", minFinalPrice)} to ${String.format("%.2f", maxFinalPrice)}.")
            }

            val date = LocalDateTime.ofInstant(Instant.parse(datetime), ZoneId.of("UTC")).truncatedTo(ChronoUnit.MINUTES)
            println(date)

            salesService.createPayment(
                final_price = finaPrice,
                price_modifier = price_modifier,
                points = points.toInt(),
                payment_method = payment_method.name,
                datetime = date
            )

            CreatePaymentResult(
                final_price = String.format("%.2f", finaPrice),
                points = points.toInt()
            )
        } catch (e: DateTimeParseException) {
            throw Error("Invalid date and time format. Allowed format is 'yyyy-MM-ddTHH:mm:ssZ'")
        }
    }
}