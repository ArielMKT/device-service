package com.deviceservice.domain.entities

data class AllBuildingDevices(
    val deviceId: String,
    val deviceDescription: String,
    val deviceState: Boolean,
    val deviceType: String,
    val workplaceId: Int,
    val buildingId: Int,
    val floorId: Int,
    val tags: List<Tag>
)
