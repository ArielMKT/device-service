package com.deviceservice.application.web.controllers

import com.deviceservice.application.web.dtos.DeviceRequestDto
import com.deviceservice.domain.services.DeviceService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

class DeviceController(
    private val deviceService: DeviceService
) {

    suspend fun createDevice(call: ApplicationCall) {
        call.receive<DeviceRequestDto>().also { deviceRequestDto ->
            deviceService.createDevice(deviceRequestDto.toDeviceRequest())
        }

        call.respond(HttpStatusCode.Created)
    }

    suspend fun device(call: ApplicationCall) {
        val deviceId = call.parameters["device"] ?: throw Exception()
        call.respond(HttpStatusCode.OK, deviceService.device(deviceId))
    }
}
