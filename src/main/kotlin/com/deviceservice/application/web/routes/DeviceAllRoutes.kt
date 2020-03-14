package com.deviceservice.application.web.routes

import com.deviceservice.application.web.controllers.DeviceAllController
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.deviceAll(deviceAllController: DeviceAllController) {
    route(path = "/all") {
        get(path = "/workplace/{workplace}") { deviceAllController.allWorkplaceDevices(this.context) }
        get(path = "/floor/{floor}") { deviceAllController.allFloorDevices(this.context) }
        get(path = "/building/{building}") { deviceAllController.allBuildingDevices(this.context) }
    }
}
