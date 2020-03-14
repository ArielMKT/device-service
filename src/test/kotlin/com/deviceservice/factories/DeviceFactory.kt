package com.deviceservice.factories

import com.deviceservice.domain.entities.Device

object DeviceFactory {
    fun sample() = Device(
        deviceId = "test123",
        deviceDescription = "test",
        deviceType = "test",
        deviceState = false,
        tagId = listOf(1, 2),
        workplaceId = 1
    )
}
