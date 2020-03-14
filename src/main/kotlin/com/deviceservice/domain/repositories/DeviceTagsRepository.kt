package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.DeviceTags

interface DeviceTagsRepository {
    fun createDeviceTags(deviceId: String, tagId: Int)
    fun allDeviceTags(deviceId: String): List<DeviceTags>
    fun deleteDeviceTags(deviceId: String, tagId: Int)
}
