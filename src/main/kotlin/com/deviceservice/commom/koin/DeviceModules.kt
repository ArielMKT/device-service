package com.deviceservice.commom.koin

import com.deviceservice.application.web.controllers.DeviceController
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.domain.repositories.DeviceTagsRepository
import com.deviceservice.domain.services.DeviceService
import com.deviceservice.resources.persistence.DeviceRepositoryImpl
import com.deviceservice.resources.persistence.DeviceTagsRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val deviceModule: Module = module {
    single { DeviceController(get()) }
    single { DeviceService(get(), get())}
    single { DeviceRepositoryImpl() as DeviceRepository }
}

val deviceTagsModule: Module = module {
    single { DeviceTagsRepositoryImpl() as DeviceTagsRepository }
}
