package com.dbasbas.pospayment.queries

import com.dbasbas.pospayment.dataclass.SaleResult
import com.dbasbas.pospayment.service.SalesService
import com.expediagroup.graphql.server.operations.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SalesQuery : Query {

    @Autowired
    lateinit var salesService: SalesService

    fun sales(
        startDateTime: String,
        endDateTime: String
    ): List<SaleResult> {
        return salesService.sales(
            startDateTime = startDateTime,
            endDateTime = endDateTime
        )
    }
}