package com.deviceservice.application.web

import com.deviceservice.application.config.DatabaseConfig
import com.deviceservice.application.config.EnvironmentConfig
import com.deviceservice.application.web.controllers.DeviceController
import com.deviceservice.application.web.routes.device
import com.deviceservice.commom.koin.deviceModule
import com.deviceservice.commom.koin.deviceTagsModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.jackson.jackson
import io.ktor.routing.Routing
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun Application.main() {
    val deviceController: DeviceController by inject()
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
        modules(deviceModule)
        modules(deviceTagsModule)
    }

    install(Routing) {
        device(deviceController = deviceController)
    }

    install(StatusPages) {
       exception(Exception::class.java) { cause ->

       }
    }
}
