package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.AllFloorDevices
import com.deviceservice.domain.entities.DeviceAllState

interface DeviceAllRepository {
    fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState
    fun allFloorDevices(floorId: Int): List<AllFloorDevices>
}
