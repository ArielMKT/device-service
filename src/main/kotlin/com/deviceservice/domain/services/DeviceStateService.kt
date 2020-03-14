package com.deviceservice.domain.services

import com.deviceservice.domain.repositories.DeviceStateRepository

class DeviceStateService(
    private val deviceStateRepository: DeviceStateRepository
) {

    fun deviceState(deviceId: String): Boolean =
        deviceStateRepository.deviceState(deviceId = deviceId)
}
