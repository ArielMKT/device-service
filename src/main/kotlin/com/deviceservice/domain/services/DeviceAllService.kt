package com.deviceservice.domain.services

import com.deviceservice.domain.entities.AllBuildingDevices
import com.deviceservice.domain.entities.AllFloorDevices
import com.deviceservice.domain.entities.AllWorkplaceDevices
import com.deviceservice.domain.repositories.DeviceAllRepository

class DeviceAllService(
    private val deviceAllRepository: DeviceAllRepository
) {

    fun allWorkplaceDevices(workplaceId: Int): List<AllWorkplaceDevices> =
        deviceAllRepository.allWorkplaceDevices(workplaceId)

    fun allFloorDevices(floorId: Int): List<AllFloorDevices> =
        deviceAllRepository.allFloorDevices(floorId)

    fun allBuildingDevices(buildingId: Int): List<AllBuildingDevices> =
        deviceAllRepository.allBuildingDevices(buildingId)
}
