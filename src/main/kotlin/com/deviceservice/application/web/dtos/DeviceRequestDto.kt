package com.deviceservice.application.web.dtos

import com.deviceservice.domain.entities.DeviceRequest

data class DeviceRequestDto(
    val deviceId: String,
    val deviceDescription: String,
    val deviceType: String,
    val tagId: List<Int>? = null,
    val workplaceId: Int
) {
    fun toDeviceRequest() = DeviceRequest (
        deviceId = deviceId,
        deviceDescription = deviceDescription,
        deviceType = deviceType,
        tagId = tagId,
        workplaceId = workplaceId
    )
}
