package com.deviceservice.domain.services

import com.deviceservice.domain.entities.Device
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.domain.repositories.DeviceTagsRepository

class DeviceService(
    private val deviceRepository: DeviceRepository,
    private val deviceTagsRepository: DeviceTagsRepository
) {

    fun createDevice(deviceRequest: Device) {
        deviceRepository.create(deviceRequest)

        deviceRequest.tagId?.forEach { tagId ->
            deviceTagsRepository.createDeviceTags(deviceId = deviceRequest.deviceId, tagId = tagId)
        }
    }

    fun device(deviceId: String) = deviceRepository.device(deviceId = deviceId)
}
