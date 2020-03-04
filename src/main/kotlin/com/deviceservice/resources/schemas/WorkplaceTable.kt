package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object WorkplaceTable : Table(name = "WORKPLACE") {
    val workplaceId = integer(name = "WORKPLACE_ID").autoIncrement()
    val floorId = (integer(name = "FLOOR_ID")
        .references(FloorTable.floorId, onDelete = ReferenceOption.CASCADE))

    override val primaryKey = PrimaryKey(workplaceId, name = "WORKPLACE_ID")
}
