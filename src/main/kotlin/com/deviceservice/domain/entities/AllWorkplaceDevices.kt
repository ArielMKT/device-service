package com.deviceservice.domain.entities

data class AllWorkplaceDevices(
    val deviceId: String,
    val deviceDescription: String,
    val deviceState: Boolean,
    val deviceType: String,
    val workplaceId: Int,
    val tags: List<Tag>
)
