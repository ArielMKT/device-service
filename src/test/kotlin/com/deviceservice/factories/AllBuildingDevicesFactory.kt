package com.deviceservice.factories

import com.deviceservice.domain.entities.AllBuildingDevices
import com.deviceservice.domain.entities.Tag

object AllBuildingDevicesFactory {
    fun sample() = AllBuildingDevices(
        deviceId = "test123",
        deviceDescription = "test",
        deviceState = false,
        deviceType = "test",
        workplaceId = 1,
        buildingId = 1,
        floorId = 1,
        tags = listOf(
            Tag(
            tagId = 1,
            tagDescription = "test",
            buildingId = 1
        )
        )
    )
}
