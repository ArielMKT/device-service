package com.deviceservice.domain.repositories

interface DeviceTagsRepository {
    fun createDeviceTags(deviceId: String, tagId: Int)
}