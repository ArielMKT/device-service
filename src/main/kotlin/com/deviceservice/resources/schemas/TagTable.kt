package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object TagTable : Table(name = "TAG") {
    val tagId = integer(name = "TAG_ID").autoIncrement()
    val tagDescription = varchar(name = "DESCRIPTION", length = 255)
    val buildingId = (integer(name = "BUILDING_ID")
        .references(BuildingTable.buildingId, onDelete = ReferenceOption.CASCADE))

    override val primaryKey = PrimaryKey(tagId, name = "TAG_ID")
}
