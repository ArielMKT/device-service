package com.deviceservice.application.web.routes

import com.deviceservice.application.web.controllers.DeviceTagsController
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.deviceTags(deviceTagsController: DeviceTagsController) {
    route("/tags") {
        post { deviceTagsController.createDeviceTags(this.context) }
    }
}
