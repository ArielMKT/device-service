package com.deviceservice.domain.entities

data class DeviceUpdate(
    val deviceId: String,
    val deviceIdUpdate: String,
    val deviceDescription: String,
    val deviceState: Boolean,
    val deviceType: String,
    val workplaceId: Int
)
