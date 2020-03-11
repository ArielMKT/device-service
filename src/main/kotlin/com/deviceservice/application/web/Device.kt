package com.deviceservice.application.web

import com.deviceservice.application.config.DatabaseConfig
import com.deviceservice.application.config.EnvironmentConfig
import com.deviceservice.application.web.controllers.DeviceAllController
import com.deviceservice.application.web.controllers.DeviceController
import com.deviceservice.application.web.controllers.DeviceTagsController
import com.deviceservice.application.web.routes.device
import com.deviceservice.application.web.routes.deviceAll
import com.deviceservice.application.web.routes.deviceTags
import com.deviceservice.commom.koin.deviceAllModule
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
    val deviceTagsController: DeviceTagsController by inject()
    val deviceAllController: DeviceAllController by inject()
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
        modules(deviceAllModule)
    }

    install(Routing) {
        device(deviceController = deviceController)
        deviceTags(deviceTagsController = deviceTagsController)
        deviceAll(deviceAllController = deviceAllController)
    }

    install(StatusPages) {
       exception(Exception::class.java) { cause ->

       }
    }
}
