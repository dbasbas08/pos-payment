package com.dbasbas.pospayment.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate


@Configuration
@EnableJpaRepositories
class DatasourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.postgres")
    fun hikariDataSource(): HikariDataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun jdbcTemplate(hikariDataSource: HikariDataSource): JdbcTemplate {
        return JdbcTemplate(hikariDataSource)
    }
}