package com.deviceservice.resources.persistence.mappers

import com.deviceservice.domain.entities.DeviceStateUpdate
import com.deviceservice.resources.schemas.DeviceTable
import org.jetbrains.exposed.sql.statements.UpdateStatement

class DeviceStateMapper {
    companion object {

        fun DeviceStateUpdate.fillUpdateRow(row: UpdateStatement) {
            row[DeviceTable.deviceId] = this.deviceId
            row[DeviceTable.deviceState] = this.deviceState
        }
    }
}
