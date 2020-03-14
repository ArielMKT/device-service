package com.deviceservice.domain.services

import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.entities.DeviceStateUpdate
import com.deviceservice.domain.repositories.DeviceStateRepository

class DeviceStateService(
    private val deviceStateRepository: DeviceStateRepository
) {

    fun deviceState(deviceId: String): Boolean =
        deviceStateRepository.deviceState(deviceId = deviceId)

    fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState =
        deviceStateRepository.allWorkplaceDeviceState(workplaceId)

    fun allFloorDeviceState(floorId: Int): DeviceAllState =
        deviceStateRepository.allFloorDeviceState(floorId = floorId)

    fun allBuildingDeviceState(buildingId: Int): DeviceAllState =
        deviceStateRepository.allBuildingDeviceState(buildingId = buildingId)

    fun updateDeviceState(device: DeviceStateUpdate) =
        deviceStateRepository.updateDeviceState(device = device)
}
