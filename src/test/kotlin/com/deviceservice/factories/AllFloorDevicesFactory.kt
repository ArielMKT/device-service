package com.deviceservice.factories

import com.deviceservice.domain.entities.AllFloorDevices
import com.deviceservice.domain.entities.Tag

object AllFloorDevicesFactory {
    fun sample() = AllFloorDevices(
        deviceId = "test123",
        deviceDescription = "test",
        deviceState = false,
        deviceType = "test",
        workplaceId = 1,
        floorId = 1,
        tags = listOf(Tag(
            tagId = 1,
            tagDescription = "test",
            buildingId = 1
        ))
    )
}
