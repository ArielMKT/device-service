package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object FloorTable : Table(name = "FLOOR") {
    val floorId = integer(name = "FLOOR_ID").autoIncrement()
    val buildingId = (integer(name = "BUILDING_ID")
        .references(BuildingTable.buildingId, onDelete = ReferenceOption.CASCADE))

    override val primaryKey = PrimaryKey(floorId, name = "FLOOR_ID")
}
