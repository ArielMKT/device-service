package com.deviceservice.resources.persistence

import com.deviceservice.domain.entities.Device
import com.deviceservice.domain.entities.DeviceUpdate
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.resources.persistence.mappers.DeviceMapper.Companion.fillInsertRow
import com.deviceservice.resources.persistence.mappers.DeviceMapper.Companion.fillUpdateRow
import com.deviceservice.resources.persistence.mappers.DeviceMapper.Companion.toDevice
import com.deviceservice.resources.schemas.DeviceTable
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class DeviceRepositoryImpl : DeviceRepository {

    override fun create(deviceRequest: Device) {
        transaction {
            DeviceTable.insert {
                deviceRequest.fillInsertRow(it)
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

    override fun update(deviceUpdate: DeviceUpdate) {
        transaction {
            DeviceTable.update({
                DeviceTable.deviceId eq deviceUpdate.deviceId
            }) {
                deviceUpdate.fillUpdateRow(it)
            }
        }
    }

    override fun delete(deviceId: String) {
        transaction {
            DeviceTable.deleteWhere {
                DeviceTable.deviceId eq deviceId
            }
        }
    }
}
