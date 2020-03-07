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
}
