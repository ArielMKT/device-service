package com.deviceservice.domain.services

import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.repositories.DeviceAllRepository

class DeviceAllService(
    private val deviceAllRepository: DeviceAllRepository
) {

    fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState =
        deviceAllRepository.allWorkplaceDeviceState(workplaceId)
}
