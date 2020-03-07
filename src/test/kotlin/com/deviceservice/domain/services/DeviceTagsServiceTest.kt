package com.deviceservice.domain.services

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.deviceservice.domain.repositories.DeviceTagsRepository
import com.deviceservice.factories.DeviceTagsRequestDtoFactory
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.junit.jupiter.api.Test

class DeviceTagsServiceTest {

    private val repository = mockk<DeviceTagsRepository>()
    private val service = DeviceTagsService(repository)
    private val deviceTagsRequest = DeviceTagsRequestDtoFactory.sample().toDeviceTags()

    @Test
    fun `given a request, service must call createDeviceTags it must create a device tags`() {
        every {
            repository.createDeviceTags(
                deviceTagsRequest.deviceId,
                deviceTagsRequest.tagId
            )
        } just runs
        every { service.createDeviceTags(deviceTagsRequest) } returns Unit

        val response = service.createDeviceTags(deviceTagsRequest)

        assertThat(response).isEqualTo(Unit)
    }
}
