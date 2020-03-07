package com.deviceservice.application.web.routes

import com.deviceservice.application.web.controllers.DeviceController
import io.ktor.routing.Routing
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.put

fun Routing.device(deviceController: DeviceController) {
    post { deviceController.createDevice(this.context) }
    get("{device}") { deviceController.device(this.context) }
    put { deviceController.updateDevice(this.context) }
    delete("{device}") { deviceController.deleteDevice(this.context) }
}
