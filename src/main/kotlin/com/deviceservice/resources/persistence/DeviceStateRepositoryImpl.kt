package com.deviceservice.resources.persistence

import com.deviceservice.domain.repositories.DeviceStateRepository
import com.deviceservice.resources.schemas.DeviceTable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class DeviceStateRepositoryImpl : DeviceStateRepository {

    override fun deviceState(deviceId: String): Boolean = transaction {
        DeviceTable.select {
            DeviceTable.deviceId.eq(deviceId)
        }.all { deviceState ->
            deviceState[DeviceTable.deviceState]
        }
    }
}
