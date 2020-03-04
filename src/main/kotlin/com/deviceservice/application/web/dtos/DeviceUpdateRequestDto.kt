package com.deviceservice.application.web.dtos

import com.deviceservice.domain.entities.DeviceUpdate

data class DeviceUpdateRequestDto(
    val deviceId: String,
    val deviceIdUpdate: String = deviceId,
    val deviceDescription: String,
    val deviceState: Boolean = false,
    val deviceType: String,
    val workplaceId: Int
) {
    fun toDeviceUpdate() = DeviceUpdate(
        deviceId = deviceId,
        deviceIdUpdate = deviceIdUpdate,
        deviceDescription = deviceDescription,
        deviceState = deviceState,
        deviceType = deviceType,
        workplaceId = workplaceId
    )
}
