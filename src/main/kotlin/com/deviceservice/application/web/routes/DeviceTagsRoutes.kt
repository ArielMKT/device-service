package com.deviceservice.application.web.routes

import com.deviceservice.application.web.controllers.DeviceTagsController
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.deviceTags(deviceTagsController: DeviceTagsController) {
    route(path = "/tags") {
        post { deviceTagsController.createDeviceTags(this.context) }
        get(path = "{device}") { deviceTagsController.allDeviceTags(this.context) }
    }
}
