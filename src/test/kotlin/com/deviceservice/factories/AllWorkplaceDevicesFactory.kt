package com.deviceservice.factories

import com.deviceservice.domain.entities.AllWorkplaceDevices
import com.deviceservice.domain.entities.Tag

object AllWorkplaceDevicesFactory {
    fun sample() = AllWorkplaceDevices(
        deviceId = "test123",
        deviceDescription = "test",
        deviceState = false,
        deviceType = "test",
        workplaceId = 1,
        tags = listOf(
            Tag(
            tagId = 1,
            tagDescription = "test",
            buildingId = 1
        )
        )
    )
}
