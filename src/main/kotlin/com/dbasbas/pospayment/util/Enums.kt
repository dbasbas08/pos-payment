package com.dbasbas.pospayment.util

enum class PaymentMethod(
    val priceMinMultiplier: Double,
    val priceMaxMultiplier: Double,
    val pointsMultiplier: Double
) {
    CASH(0.9, 1.00, 0.05),
    CASH_ON_DELIVERY(1.00, 1.02, 0.05),
    VISA(0.95, 1.00, 0.03),
    MASTERCARD(0.95, 1.00, 0.03),
    AMEX(0.98, 1.01, 0.02),
    JCB(0.95, 1.00, 0.05)
}