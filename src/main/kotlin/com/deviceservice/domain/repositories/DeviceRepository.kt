package com.deviceservice.domain.repositories

import com.deviceservice.domain.entities.Device

interface DeviceRepository {
    fun create(deviceRequest: Device)
    fun device(deviceId: String): Device
}
