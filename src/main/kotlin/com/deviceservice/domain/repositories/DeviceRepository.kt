package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.DeviceRequest

interface DeviceRepository {
    fun create(deviceRequest: DeviceRequest)
}
