package com.deviceservice.factories

import com.deviceservice.application.web.dtos.DeviceUpdateRequestDto

object DeviceUpdateRequestDtoFactory {
    fun sample() = DeviceUpdateRequestDto(
        deviceId = "test",
        deviceIdUpdate = "test",
        deviceDescription = "test",
        deviceState = false,
        deviceType = "test",
        workplaceId = 1
    )
}
