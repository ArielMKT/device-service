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
            deviceAllService.allWorkplaceDevices(workplaceId.toInt())
        )
    }

    suspend fun allFloorDevices(call: ApplicationCall) {
        val floorId = call.parameters["floor"] ?: throw Exception()
        call.respond(
            HttpStatusCode.OK,
            deviceAllService.allFloorDevices(floorId.toInt())
        )
    }

    suspend fun allBuildingDevices(call: ApplicationCall) {
        val buildingId = call.parameters["building"] ?: throw Exception()
        call.respond(
            HttpStatusCode.OK,
            deviceAllService.allBuildingDevices(buildingId.toInt())
        )
    }
}
