package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.Device
import com.deviceservice.domain.entities.DeviceUpdate

interface DeviceRepository {
    fun create(deviceRequest: Device)
    fun device(deviceId: String): Device
    fun update(deviceUpdate: DeviceUpdate)
}
