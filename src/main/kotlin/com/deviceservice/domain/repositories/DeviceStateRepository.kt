package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.DeviceAllState

interface DeviceStateRepository {
    fun deviceState(deviceId: String): Boolean
    fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState
    fun allFloorDeviceState(floorId: Int): DeviceAllState
}
