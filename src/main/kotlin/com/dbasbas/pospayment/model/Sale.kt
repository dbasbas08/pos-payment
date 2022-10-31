package com.dbasbas.pospayment.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "sales")
data class Sale(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "final_price")
    val final_price: Double,
    @Column(name = "price_modifier")
    val price_modifier: Double,
    @Column(name = "points")
    val points: Int,
    @Column(name = "payment_method")
    val payment_method: String,
    @Column(name = "datetime")
    val datetime: Timestamp
)