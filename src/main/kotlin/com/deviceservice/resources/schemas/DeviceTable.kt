package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object DeviceTable : Table(name = "DEVICE") {
    val deviceId = varchar(name = "DEVICE_ID", length = 255)
    val deviceState = bool(name = "STATE")
    val deviceDescription = varchar(name = "DESCRIPTION", length = 255)
    val deviceType = varchar(name = "TYPE", length = 255)
    val workplaceId = (integer(name = "WORKPLACE_ID")
        .references(WorkplaceTable.workplaceId, onDelete = ReferenceOption.CASCADE))

    override val primaryKey = PrimaryKey(deviceId, name = "DEVICE_ID")
}
