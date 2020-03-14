package com.deviceservice.application.web.controllers

import com.deviceservice.application.web.dtos.DeviceStateUpdateRequestDto
import com.deviceservice.domain.services.DeviceStateService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
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

    suspend fun allFloorDeviceState(call: ApplicationCall) {
        val floorId = call.parameters["floor"] ?: throw Exception()
        call.respond(HttpStatusCode.OK, deviceStateService.allFloorDeviceState(floorId.toInt()))
    }

    suspend fun allBuildingDeviceState(call: ApplicationCall) {
        val buildingId = call.parameters["building"] ?: throw Exception()
        call.respond(HttpStatusCode.OK, deviceStateService.allBuildingDeviceState(buildingId.toInt()))
    }

    suspend fun updateDeviceState(call: ApplicationCall) =
        call.receive<DeviceStateUpdateRequestDto>().also { deviceStateUpdateRequestDto ->
            deviceStateService.updateDeviceState(deviceStateUpdateRequestDto.toDeviceStateUpdateRequest())
        }
}
