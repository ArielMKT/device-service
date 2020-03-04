package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object BuildingTable : Table(name = "BUILDING") {
    val buildingId = integer(name = "BUILDING_ID").autoIncrement()
    val companyId = (integer(name = "COMPANY_ID")
        .references(CompanyTable.companyId, onDelete = ReferenceOption.CASCADE))

    override val primaryKey = PrimaryKey(buildingId, name = "BUILDING_ID")
}
