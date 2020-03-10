package com.deviceservice.application.web.controllers

import com.deviceservice.application.web.dtos.DeviceTagsRequestDto
import com.deviceservice.domain.services.DeviceTagsService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

class DeviceTagsController(
    private val deviceTagsService: DeviceTagsService
) {

    suspend fun createDeviceTags(call: ApplicationCall) {
        call.receive<DeviceTagsRequestDto>().also { deviceTagsRequestDto ->
            deviceTagsService.createDeviceTags(deviceTagsRequestDto.toDeviceTags())
        }

        call.respond(HttpStatusCode.Created)
    }

    suspend fun allDeviceTags(call: ApplicationCall) {
        val deviceId = call.parameters["device"] ?: throw Exception()
        call.respond(HttpStatusCode.OK, deviceTagsService.allDeviceTags(deviceId))
    }
}
