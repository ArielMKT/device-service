package com.deviceservice.domain.services

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.deviceservice.domain.repositories.DeviceStateRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class DeviceStateServiceTest {

    private val repository = mockk<DeviceStateRepository>()
    private val service = DeviceStateService(repository)
    private val deviceId = "test123"

    @Test
    fun `given a request, service must call deviceState it must return a state of a device`() {
        every { repository.deviceState(deviceId) } returns true

        val response = service.deviceState(deviceId)

        assertThat(response).isEqualTo(true)
    }
}
