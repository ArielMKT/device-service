package com.deviceservice.resources.schemas

import org.jetbrains.exposed.sql.Table

object CompanyTable : Table(name = "COMPANY") {
    val companyId = integer(name = "COMPANY_ID").autoIncrement()

    override val primaryKey = PrimaryKey(companyId, name = "COMPANY_ID")
}
