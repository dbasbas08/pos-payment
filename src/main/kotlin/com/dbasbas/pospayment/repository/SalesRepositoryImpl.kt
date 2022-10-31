package com.dbasbas.pospayment.repository

import com.dbasbas.pospayment.dataclass.SaleResult
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeParseException
import kotlin.streams.toList

@Repository
class SalesRepositoryImpl(val jdbcTemplate: JdbcTemplate): SalesRepository {

    override fun sales(
        startDateTime: String,
        endDateTime: String
    ): List<SaleResult> {
        return try {
            val start = Instant.parse(startDateTime)
            val end = Instant.parse(endDateTime)
            if (start.isAfter(end)) {
                throw Error("Invalid start and end date time.")
            }
            val sql = "WITH date_series AS " +
                    "(SELECT * FROM generate_series('$start'::timestamp, '$end'::timestamp, '1 hour'::interval) report_date), " +
                    "sales_overview AS " +
                    "(SELECT date_trunc('hour', datetime) AS datetime, SUM(coalesce(final_price, 0)) AS final_price, SUM(coalesce(points, 0)) AS points " +
                    "FROM sales GROUP BY date_trunc('hour', datetime)) " +
                    "SELECT * FROM date_series d LEFT JOIN sales_overview o ON d.report_date = o.datetime"
            val mapper = SalesRowMapper()
            jdbcTemplate.queryForStream(sql, mapper).toList()
        } catch (e: DateTimeParseException) {
            throw Error("Invalid date and time format. Allowed format is 'yyyy-MM-ddTHH:mm:ssZ'")
        }
    }

    override fun createPayment(
        final_price: Double,
        price_modifier: Double,
        points: Int,
        payment_method: String,
        datetime: LocalDateTime
    ) {
        val sql = "INSERT INTO sales(final_price, price_modifier, points, payment_method, datetime) VALUES (?,?,?,?,?);"
        jdbcTemplate.update(sql, final_price, price_modifier, points, payment_method, datetime)
    }
}