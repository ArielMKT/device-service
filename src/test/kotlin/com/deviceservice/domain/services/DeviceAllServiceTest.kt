package com.deviceservice.domain.services

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.repositories.DeviceAllRepository
import com.deviceservice.factories.AllFloorDevicesFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class DeviceAllServiceTest {

    private val repository = mockk<DeviceAllRepository>()
    private val service = DeviceAllService(repository)
    private val allFloorDevices = listOf(AllFloorDevicesFactory.sample())
    private val floorId = allFloorDevices[0].floorId
    private val workplaceId = 1
    private val deviceAllState = DeviceAllState(
        devicesOn = 1,
        devicesOff = 1,
        allDevices = 2
    )

    @Test
    fun `given a request, service must call allWorkplaceDeviceState it must return a device state's`() {
        every { repository.allWorkplaceDeviceState(workplaceId) } returns deviceAllState

        val response = service.allWorkplaceDeviceState(workplaceId)

        assertThat(response).isEqualTo(deviceAllState)
    }

    @Test
    fun `given a request, service must call allFloorDevices it must return a of allFloorDevices`() {
        every { repository.allFloorDevices(floorId) } returns allFloorDevices

        val response = service.allFloorDevices(floorId)

        assertThat(response).isEqualTo(allFloorDevices)
    }
}
