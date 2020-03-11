package com.deviceservice.application.web.controllers

import com.deviceservice.domain.services.DeviceAllService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class DeviceAllController(
    private val deviceAllService: DeviceAllService
) {

    suspend fun allWorkplaceDevices(call: ApplicationCall)  {
        val workplaceId = call.parameters["workplace"] ?: throw Exception()
        call.respond(
            HttpStatusCode.OK,
            deviceAllService.allWorkplaceDeviceState(workplaceId.toInt())
        )
    }

    suspend fun allFloorDevices(call: ApplicationCall) {
        val floorId = call.parameters["floor"] ?: throw Exception()
        call.respond(
            HttpStatusCode.OK,
            deviceAllService.allFloorDevices(floorId.toInt())
        )
    }
}
