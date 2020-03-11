package com.deviceservice.resources.persistence

import com.deviceservice.domain.entities.AllFloorDevices
import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.repositories.DeviceAllRepository
import com.deviceservice.resources.persistence.mappers.DeviceAllMapper.Companion.toAllFloorDevices
import com.deviceservice.resources.schemas.BuildingTable
import com.deviceservice.resources.schemas.DeviceTable
import com.deviceservice.resources.schemas.FloorTable
import com.deviceservice.resources.schemas.WorkplaceTable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class DeviceAllRepositoryImpl : DeviceAllRepository {

    override fun allWorkplaceDeviceState(workplaceId: Int): DeviceAllState = transaction {
        var devicesOn = 0
        var allDevices = 0

        (DeviceTable innerJoin WorkplaceTable innerJoin FloorTable innerJoin BuildingTable)
            .select {
                DeviceTable.workplaceId.eq(workplaceId)
            }.map { allDevicesState ->
                if (allDevicesState[DeviceTable.deviceState])
                    devicesOn++

                allDevices++
            }

        DeviceAllState(
            devicesOn = devicesOn,
            devicesOff = (allDevices - devicesOn),
            allDevices = allDevices
        )
    }

    override fun allFloorDevices(floorId: Int): List<AllFloorDevices> = transaction {
        (DeviceTable innerJoin WorkplaceTable innerJoin FloorTable)
            .select {
                FloorTable.floorId.eq(floorId)
            }.map {
                it.toAllFloorDevices()
            }
    }
}
