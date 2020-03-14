package com.deviceservice.resources.persistence.mappers

import com.deviceservice.domain.entities.DeviceTags
import com.deviceservice.resources.schemas.DeviceTagsTable
import com.deviceservice.resources.schemas.TagTable
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toDeviceTags(deviceId: String) = DeviceTags(
    deviceId = deviceId,
    tagId = this[DeviceTagsTable.tagId],
    tagDescription = this[TagTable.tagDescription]
)
