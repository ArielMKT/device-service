package com.deviceservice.application.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object DatabaseConfig {
    fun setup(jdbcUrl: String, username: String, password: String) {

        val config = HikariConfig().also { config ->
            config.jdbcUrl = jdbcUrl
            config.username = username
            config.password = password
        }

        Database.connect(HikariDataSource(config))
    }
}
