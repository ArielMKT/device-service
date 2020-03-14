package com.deviceservice.resources.persistence.mappers

import com.deviceservice.domain.entities.Device
import com.deviceservice.domain.entities.DeviceUpdate
import com.deviceservice.resources.schemas.DeviceTable
import com.deviceservice.resources.schemas.DeviceTagsTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement

fun Device.fillInsertRow(row: InsertStatement<*>) {
    row[DeviceTable.deviceId] = this.deviceId
    row[DeviceTable.deviceDescription] = this.deviceDescription
    row[DeviceTable.deviceState] = this.deviceState
    row[DeviceTable.deviceType] = this.deviceType
    row[DeviceTable.workplaceId] = this.workplaceId
}

fun DeviceUpdate.fillUpdateRow(row: UpdateStatement) {
    row[DeviceTable.deviceId] = this.deviceIdUpdate
    row[DeviceTable.deviceDescription] = this.deviceDescription
    row[DeviceTable.deviceState] = this.deviceState
    row[DeviceTable.deviceType] = this.deviceType
    row[DeviceTable.workplaceId] = this.workplaceId
}

fun ResultRow.toDevice(deviceId: String) = Device(
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
