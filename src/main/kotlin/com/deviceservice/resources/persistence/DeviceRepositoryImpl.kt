package com.deviceservice.resources.persistence

import com.deviceservice.domain.entities.Device
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.resources.schemas.DeviceTable
import com.deviceservice.resources.schemas.DeviceTagsTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class DeviceRepositoryImpl : DeviceRepository {

    override fun create(deviceRequest: Device) {
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

    override fun device(deviceId: String): Device = transaction {
        DeviceTable.select {
            DeviceTable.deviceId eq deviceId
        }.map {
            it.toDevice(deviceId)
        }.first()
    }

    private fun ResultRow.toDevice(deviceId: String) = Device(
        deviceId = this[DeviceTable.deviceId],
        deviceDescription = this[DeviceTable.deviceDescription],
        deviceState = this[DeviceTable.deviceState],
        deviceType = this[DeviceTable.deviceType],
        workplaceId = this[DeviceTable.workplaceId],
        tagId = DeviceTagsTable.select {
            DeviceTagsTable.deviceId eq deviceId
        }.map { tags ->
            tags[DeviceTagsTable.tagId]
        }
    )
}
