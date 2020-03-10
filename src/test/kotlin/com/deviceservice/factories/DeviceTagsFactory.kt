package com.deviceservice.factories

import com.deviceservice.domain.entities.DeviceTags

object DeviceTagsFactory {

    fun sample() = DeviceTags(
        deviceId = "test123",
        tagId = 1,
        tagDescription = "test123"
    )
}
