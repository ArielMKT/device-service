package com.deviceservice.domain.services

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.repositories.DeviceAllRepository
import com.deviceservice.factories.AllBuildingDevicesFactory
import com.deviceservice.factories.AllFloorDevicesFactory
import com.deviceservice.factories.AllWorkplaceDevicesFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class DeviceAllServiceTest {

    private val repository = mockk<DeviceAllRepository>()
    private val service = DeviceAllService(repository)
    private val allWorkplaceDevices = listOf(AllWorkplaceDevicesFactory.sample())
    private val allFloorDevices = listOf(AllFloorDevicesFactory.sample())
    private val allBuildingDevices = listOf(AllBuildingDevicesFactory.sample())
    private val workplaceId = allWorkplaceDevices.first().workplaceId
    private val floorId = allFloorDevices.first().floorId
    private val buildingId = allBuildingDevices.first().buildingId

    @Test
    fun `given a request, service must call allWorkplaceDevices it must return a list of allWorkplaceDevices`() {
        every { repository.allWorkplaceDevices(workplaceId) } returns allWorkplaceDevices

        val response = service.allWorkplaceDevices(workplaceId)

        assertThat(response).isEqualTo(allWorkplaceDevices)
    }

    @Test
    fun `given a request, service must call allFloorDevices it must return a list of allFloorDevices`() {
        every { repository.allFloorDevices(floorId) } returns allFloorDevices

        val response = service.allFloorDevices(floorId)

        assertThat(response).isEqualTo(allFloorDevices)
    }

    @Test
    fun `given a request, service must call allBuildingDevices it must return a list of allBuildingDevices`() {
        every { repository.allBuildingDevices(buildingId) } returns allBuildingDevices

        val response = service.allBuildingDevices(buildingId)

        assertThat(response).isEqualTo(allBuildingDevices)
    }
}
