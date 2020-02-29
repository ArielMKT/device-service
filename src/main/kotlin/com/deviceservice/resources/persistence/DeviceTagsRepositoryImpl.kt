package com.deviceservice.resources.persistence

import com.deviceservice.domain.repositories.DeviceTagsRepository
import com.deviceservice.resources.schemas.DeviceTagsTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class DeviceTagsRepositoryImpl : DeviceTagsRepository {

    override fun createDeviceTags(deviceId: String, tagId: Int) {
        transaction {
            DeviceTagsTable.insert {
                it[DeviceTagsTable.tagId] = tagId
                it[DeviceTagsTable.deviceId] = deviceId
            }
        }
    }
}
