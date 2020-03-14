package com.deviceservice.application.web.dtos

import com.deviceservice.domain.entities.DeviceStateUpdate

data class DeviceStateUpdateRequestDto (
    val deviceId: String,
    val deviceState: Boolean
) {
    fun toDeviceStateUpdateRequest() = DeviceStateUpdate(
        deviceId = deviceId,
        deviceState = deviceState
    )
}
