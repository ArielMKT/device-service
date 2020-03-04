package com.deviceservice.domain.services

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.domain.repositories.DeviceTagsRepository
import com.deviceservice.factories.DeviceFactory
import com.deviceservice.factories.DeviceRequestDtoFactory
import com.deviceservice.factories.DeviceUpdateRequestDtoFactory
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.junit.jupiter.api.Test

class DeviceServiceTest {

    private val deviceRepository = mockk<DeviceRepository>()
    private val deviceTagsRepository = mockk<DeviceTagsRepository>()
    private val service = DeviceService(deviceRepository, deviceTagsRepository)
    private val deviceRequest = DeviceRequestDtoFactory.sample().toDeviceRequest()
    private val deviceUpdateRequest = DeviceUpdateRequestDtoFactory.sample().toDeviceUpdate()
    private val device = DeviceFactory.sample()
    private val deviceId = deviceRequest.deviceId
    private val tagId = 1

    @Test
    fun `given a request, service must call createDevice it must create a device and device tags`() {
        every { deviceRepository.create(deviceRequest) } just runs
        every { deviceTagsRepository.createDeviceTags(deviceId, tagId) } just runs
        every { service.createDevice(deviceRequest) } returns Unit

        val response = service.createDevice(deviceRequest)

        assertThat(response).isEqualTo(Unit)
    }

    @Test
    fun `given a request with deviceId, service must call device it must return a device`() {
        every { deviceRepository.device(deviceId) } returns device
        every { service.device(deviceId) } returns device

        val response = service.device(deviceId)

        assertThat(response).isEqualTo(device)
    }

    @Test
    fun `given a request, service must call updateDevice it must update a device and device tags`() {
        every { deviceRepository.update(deviceUpdateRequest) } just runs
        every { service.updateDevice(deviceUpdateRequest) } returns Unit

        val response = service.updateDevice(deviceUpdateRequest)

        assertThat(response).isEqualTo(Unit)
    }
}
