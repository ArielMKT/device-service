package com.deviceservice.resources.persistence

import com.deviceservice.domain.entities.DeviceRequest
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.resources.schemas.DeviceTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class DeviceRepositoryImpl : DeviceRepository {

    override fun create(deviceRequest: DeviceRequest) {
        transaction {
            DeviceTable.insert {
                it[deviceId] = deviceRequest.deviceId
                it[deviceDescription] = deviceRequest.deviceDescription
                it[deviceState] = deviceRequest.deviceState
                it[deviceType] = deviceRequest.deviceType
                it[workplaceId] = deviceRequest.workplaceId
            }
        }
    }
}
