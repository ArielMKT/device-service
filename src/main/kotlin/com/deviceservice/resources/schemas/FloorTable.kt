package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object FloorTable : Table(name = "FLOOR") {
    val floorId = integer(name = "FLOOR_ID").primaryKey().autoIncrement()
    val buildingId = (integer(name = "BUILDING_ID")
        .references(BuildingTable.buildingId, onDelete = ReferenceOption.CASCADE))
}
