package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.entities.DeviceStateUpdate

interface DeviceStateRepository {
    fun deviceState(deviceId: String): Boolean
    fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState
    fun allFloorDeviceState(floorId: Int): DeviceAllState
    fun allBuildingDeviceState(buildingId: Int): DeviceAllState
    fun updateDeviceState(device: DeviceStateUpdate)
}
