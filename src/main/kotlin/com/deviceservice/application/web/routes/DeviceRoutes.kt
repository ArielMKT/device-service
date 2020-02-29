package com.deviceservice.application.web.routes

import com.deviceservice.application.web.controllers.DeviceController
import io.ktor.routing.Routing
import io.ktor.routing.post

fun Routing.device(deviceController: DeviceController) {
    post { deviceController.createDevice(this.context) }
}
