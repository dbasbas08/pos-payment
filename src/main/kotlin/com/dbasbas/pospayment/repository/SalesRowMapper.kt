package com.dbasbas.pospayment.repository

import com.dbasbas.pospayment.dataclass.SaleResult
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.time.LocalDateTime
import java.time.ZoneOffset

class SalesRowMapper: RowMapper<SaleResult> {

    override fun mapRow(rs: ResultSet, rowNum: Int): SaleResult {
        return SaleResult(
            sales = String.format("%.2f", rs.getDouble("final_price")),
            points = rs.getInt("points"),
            datetime = rs.getObject("report_date", LocalDateTime::class.java).toInstant(ZoneOffset.UTC).toString()
        )
    }
}