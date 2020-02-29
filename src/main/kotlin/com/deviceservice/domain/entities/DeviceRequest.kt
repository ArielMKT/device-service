package com.deviceservice.domain.entities

data class DeviceRequest(
    val deviceId: String,
    val deviceDescription: String,
    val deviceState: Boolean = false,
    val deviceType: String,
    val tagId: List<Int>?,
    val workplaceId: Int
)
