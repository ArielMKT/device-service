package com.deviceservice.commom.koin

import com.deviceservice.application.web.controllers.DeviceAllController
import com.deviceservice.application.web.controllers.DeviceController
import com.deviceservice.application.web.controllers.DeviceTagsController
import com.deviceservice.domain.repositories.DeviceAllRepository
import com.deviceservice.domain.repositories.DeviceRepository
import com.deviceservice.domain.repositories.DeviceTagsRepository
import com.deviceservice.domain.services.DeviceAllService
import com.deviceservice.domain.services.DeviceService
import com.deviceservice.domain.services.DeviceTagsService
import com.deviceservice.resources.persistence.DeviceAllRepositoryImpl
import com.deviceservice.resources.persistence.DeviceRepositoryImpl
import com.deviceservice.resources.persistence.DeviceTagsRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val deviceModule: Module = module {
    single { DeviceController(get()) }
    single { DeviceService(get(), get())}
    single<DeviceRepository> { DeviceRepositoryImpl() }
}

val deviceTagsModule: Module = module {
    single { DeviceTagsController(get()) }
    single { DeviceTagsService(get()) }
    single<DeviceTagsRepository> { DeviceTagsRepositoryImpl() }
}

val deviceAllModule: Module = module {
    single { DeviceAllController(get()) }
    single { DeviceAllService(get()) }
    single<DeviceAllRepository> { DeviceAllRepositoryImpl() }
}
