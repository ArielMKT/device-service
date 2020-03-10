package com.deviceservice.domain.services

import com.deviceservice.domain.entities.DeviceTags
import com.deviceservice.domain.repositories.DeviceTagsRepository

class DeviceTagsService(
    private val deviceTagsRepository: DeviceTagsRepository
) {

    fun createDeviceTags(deviceTagsRequest: DeviceTags) {
        deviceTagsRepository.createDeviceTags(
            deviceId = deviceTagsRequest.deviceId,
            tagId = deviceTagsRequest.tagId
        )
    }

    fun allDeviceTags(deviceId: String): List<DeviceTags> =
        deviceTagsRepository.allDeviceTags(deviceId = deviceId)

    fun deleteDeviceTags(deviceTagsDelete: DeviceTags) =
        deviceTagsRepository.deleteDeviceTags(
            deviceId = deviceTagsDelete.deviceId,
            tagId = deviceTagsDelete.tagId
        )
}
