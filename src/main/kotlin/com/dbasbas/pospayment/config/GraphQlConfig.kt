package com.dbasbas.pospayment.config

import graphql.scalars.ExtendedScalars
import graphql.schema.idl.RuntimeWiring
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GraphQlConfig {

    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiring.Builder? {
        return RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.DateTime)
    }

}