package com.deviceservice.resources.persistence.mappers

import com.deviceservice.domain.entities.AllBuildingDevices
import com.deviceservice.domain.entities.AllFloorDevices
import com.deviceservice.domain.entities.Tag
import com.deviceservice.resources.persistence.mappers.DeviceAllMapper.Companion.toAllFloorDevices
import com.deviceservice.resources.schemas.BuildingTable
import com.deviceservice.resources.schemas.DeviceTable
import com.deviceservice.resources.schemas.DeviceTagsTable
import com.deviceservice.resources.schemas.FloorTable
import com.deviceservice.resources.schemas.TagTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select

class DeviceAllMapper {
    companion object {

        fun ResultRow.toAllFloorDevices() = AllFloorDevices(
            deviceId = this[DeviceTable.deviceId],
            deviceDescription = this[DeviceTable.deviceDescription],
            deviceState = this[DeviceTable.deviceState],
            deviceType = this[DeviceTable.deviceType],
            workplaceId = this[DeviceTable.workplaceId],
            floorId = this[FloorTable.floorId],
            tags = (TagTable innerJoin DeviceTagsTable).select {
                DeviceTagsTable.deviceId.eq(this@toAllFloorDevices[DeviceTable.deviceId])
            }.map { tags ->
                Tag(
                    tagId = tags[TagTable.tagId],
                    tagDescription = tags[TagTable.tagDescription],
                    buildingId = tags[TagTable.buildingId]
                )
            }
        )

        fun ResultRow.toAllBuildingDevices() = AllBuildingDevices(
            deviceId = this[DeviceTable.deviceId],
            deviceDescription = this[DeviceTable.deviceDescription],
            deviceState = this[DeviceTable.deviceState],
            deviceType = this[DeviceTable.deviceType],
            workplaceId = this[DeviceTable.workplaceId],
            buildingId = this[BuildingTable.buildingId],
            floorId = this[FloorTable.floorId],
            tags = (TagTable innerJoin DeviceTagsTable).select {
                DeviceTagsTable.deviceId.eq(this@toAllBuildingDevices[DeviceTable.deviceId])
            }.map { tags ->
                Tag(
                    tagId = tags[TagTable.tagId],
                    tagDescription = tags[TagTable.tagDescription],
                    buildingId = tags[TagTable.buildingId]
                )
            }
        )
    }
}
