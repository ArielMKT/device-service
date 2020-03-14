package com.deviceservice.factories

import com.deviceservice.application.web.dtos.DeviceStateUpdateRequestDto

object DeviceStateUpdateRequestDtoFactory {
    fun sample() = DeviceStateUpdateRequestDto(
        deviceId = "test123",
        deviceState = true
    )
}
