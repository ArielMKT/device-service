package com.deviceservice.domain.entities

data class AllFloorDevices (
    val deviceId: String,
    val deviceDescription: String,
    val deviceState: Boolean,
    val deviceType: String,
    val workplaceId: Int,
    val floorId: Int,
    val tags: List<Tag>
)
