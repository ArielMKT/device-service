package com.deviceservice.application.web.dtos

import com.deviceservice.domain.entities.DeviceTags

data class DeviceTagsRequestDto (
    val deviceId: String,
    val tagId: Int
) {
    fun toDeviceTags() = DeviceTags(
        deviceId = deviceId,
        tagId = tagId,
        tagDescription = null
    )
}
