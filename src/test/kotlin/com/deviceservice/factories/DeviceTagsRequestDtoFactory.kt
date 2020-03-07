package com.deviceservice.factories

import com.deviceservice.application.web.dtos.DeviceTagsRequestDto

object DeviceTagsRequestDtoFactory {
    fun sample() = DeviceTagsRequestDto(
        deviceId = "test123",
        tagId = 1
    )
}
