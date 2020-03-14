package com.deviceservice.application.web.controllers

import com.deviceservice.domain.services.DeviceStateService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class DeviceStateController(
    private val deviceStateService: DeviceStateService
) {

    suspend fun deviceState(call: ApplicationCall) {
        val deviceId = call.parameters["device"] ?: throw Exception()
        call.respond(HttpStatusCode.OK, deviceStateService.deviceState(deviceId))
    }

    suspend fun allWorkplaceDeviceState(call: ApplicationCall) {
        val workplaceId = call.parameters["workplace"] ?: throw Exception()
        call.respond(HttpStatusCode.OK, deviceStateService.allWorkplaceDeviceState(workplaceId.toInt()))
    }
}
