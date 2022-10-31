package com.dbasbas.pospayment

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@AutoConfiguration
class PosPaymentApplication

fun main(args: Array<String>) {
	runApplication<PosPaymentApplication>(*args)
}
