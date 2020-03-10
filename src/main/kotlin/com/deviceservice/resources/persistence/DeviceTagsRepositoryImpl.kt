package com.deviceservice.resources.persistence

import com.deviceservice.domain.entities.DeviceTags
import com.deviceservice.domain.repositories.DeviceTagsRepository
import com.deviceservice.resources.persistence.mappers.DeviceTagsMapper.Companion.toDeviceTags
import com.deviceservice.resources.schemas.DeviceTagsTable
import com.deviceservice.resources.schemas.TagTable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
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

    override fun allDeviceTags(deviceId: String): List<DeviceTags> =
        transaction {
            (DeviceTagsTable innerJoin TagTable)
                .select {
                    DeviceTagsTable.deviceId.eq(deviceId)
                        .and(TagTable.tagId.eq(DeviceTagsTable.tagId))
                }.map {
                    it.toDeviceTags(deviceId)
                }
        }

    override fun deleteDeviceTags(deviceId: String, tagId: Int) {
        transaction {
            DeviceTagsTable.deleteWhere {
                DeviceTagsTable.deviceId.eq(deviceId).and(
                    DeviceTagsTable.tagId.eq(tagId)
                )
            }
        }
    }
}
