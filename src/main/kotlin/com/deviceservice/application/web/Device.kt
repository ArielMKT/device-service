package com.deviceservice.application.web

import com.deviceservice.application.config.DatabaseConfig
import com.deviceservice.application.config.EnvironmentConfig
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin

fun Application.main() {
    val environmentConfig = EnvironmentConfig

    DatabaseConfig.setup(
        jdbcUrl = environmentConfig.databaseUrl,
        username = environmentConfig.databaseUser,
        password = environmentConfig.databasePassword
    )

    install(DefaultHeaders)

    install(CORS)

    install(CallLogging)

    install(ContentNegotiation) {
        jackson()
    }

    install(Koin) {
        slf4jLogger()

    }

    install(Routing) {

    }

    install(StatusPages) {
       exception(Exception::class.java) { cause ->

       }
    }
}
