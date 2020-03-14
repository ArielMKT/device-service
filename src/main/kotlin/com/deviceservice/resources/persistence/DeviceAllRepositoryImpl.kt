package com.deviceservice.resources.persistence

import com.deviceservice.domain.entities.AllBuildingDevices
import com.deviceservice.domain.entities.AllFloorDevices
import com.deviceservice.domain.entities.AllWorkplaceDevices
import com.deviceservice.domain.repositories.DeviceAllRepository
import com.deviceservice.resources.persistence.mappers.toAllBuildingDevices
import com.deviceservice.resources.persistence.mappers.toAllFloorDevices
import com.deviceservice.resources.persistence.mappers.toAllWorkplaceDevices
import com.deviceservice.resources.schemas.BuildingTable
import com.deviceservice.resources.schemas.DeviceTable
import com.deviceservice.resources.schemas.FloorTable
import com.deviceservice.resources.schemas.WorkplaceTable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class DeviceAllRepositoryImpl : DeviceAllRepository {

    override fun allWorkplaceDevices(workplaceId: Int): List<AllWorkplaceDevices> = transaction {
        DeviceTable.select {
            DeviceTable.workplaceId.eq(workplaceId)
        }.map {
            it.toAllWorkplaceDevices()
        }
    }

    override fun allFloorDevices(floorId: Int): List<AllFloorDevices> = transaction {
        (DeviceTable innerJoin WorkplaceTable innerJoin FloorTable)
            .select {
                FloorTable.floorId.eq(floorId)
            }.map {
                it.toAllFloorDevices()
            }
    }

    override fun allBuildingDevices(buildingId: Int): List<AllBuildingDevices> = transaction {
        (DeviceTable innerJoin WorkplaceTable innerJoin FloorTable innerJoin BuildingTable)
            .select {
                BuildingTable.buildingId.eq(buildingId)
            }.map {
                it.toAllBuildingDevices()
            }
    }
}
