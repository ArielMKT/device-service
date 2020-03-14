package com.deviceservice.domain.services

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.deviceservice.domain.entities.DeviceAllState
import com.deviceservice.domain.repositories.DeviceStateRepository
import com.deviceservice.factories.DeviceStateUpdateRequestDtoFactory
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.junit.jupiter.api.Test

class DeviceStateServiceTest {

    private val repository = mockk<DeviceStateRepository>()
    private val service = DeviceStateService(repository)
    private val deviceId = "test123"
    private val workplaceId = 1
    private val floorId = 1
    private val buildingId = 1
    private val updateDeviceState = DeviceStateUpdateRequestDtoFactory.sample().toDeviceStateUpdateRequest()
    private val deviceAllState = DeviceAllState(
        devicesOn = 1,
        devicesOff = 1,
        allDevices = 2
    )

    @Test
    fun `given a request, service must call deviceState it must return a state of a device`() {
        every { repository.deviceState(deviceId) } returns true

        val response = service.deviceState(deviceId)

        assertThat(response).isEqualTo(true)
    }

    @Test
    fun `given a request, service must call allWorkplaceDeviceState it must return a device state's`() {
        every { repository.allWorkplaceDeviceState(workplaceId) } returns deviceAllState

        val response = service.allWorkplaceDeviceState(workplaceId)

        assertThat(response).isEqualTo(deviceAllState)
    }

    @Test
    fun `given a request, service must call allFloorDeviceState it must return a device state's`() {
        every { repository.allFloorDeviceState(floorId) } returns deviceAllState

        val response = service.allFloorDeviceState(floorId)

        assertThat(response).isEqualTo(deviceAllState)
    }

    @Test
    fun `given a request, service must call allBuildingDeviceState it must return a device state's`() {
        every { repository.allBuildingDeviceState(buildingId) } returns deviceAllState

        val response = service.allBuildingDeviceState(buildingId)

        assertThat(response).isEqualTo(deviceAllState)
    }

    @Test
    fun `given a request, service must call updateDeviceState it must update a device state`() {
        every { repository.updateDeviceState(updateDeviceState) } just runs

        val response = service.updateDeviceState(updateDeviceState)

        assertThat(response).isEqualTo(Unit)
    }
}
