package com.deviceservice.domain.repositories

interface DeviceStateRepository {
    fun deviceState(deviceId: String): Boolean
}
