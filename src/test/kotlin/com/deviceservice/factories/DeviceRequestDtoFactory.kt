package com.deviceservice.factories

import com.deviceservice.application.web.dtos.DeviceRequestDto

object DeviceRequestDtoFactory {
    fun sample() = DeviceRequestDto(
        deviceId = "test123",
        deviceDescription = "test",
        deviceType = "test",
        tagId = listOf(1, 2),
        workplaceId = 1
    )
}
