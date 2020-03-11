package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.DeviceAllState

interface DeviceAllRepository {
    fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState
}
