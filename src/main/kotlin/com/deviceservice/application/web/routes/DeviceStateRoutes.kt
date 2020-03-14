package com.deviceservice.application.web.routes

import com.deviceservice.application.web.controllers.DeviceStateController
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.deviceState(deviceStateController: DeviceStateController) {
    route(path = "/state") {
        get(path = "/{device}") { deviceStateController.deviceState(this.context) }
        get(path = "/workplace/{workplace}") { deviceStateController.allWorkplaceDeviceState(this.context) }
        get(path = "/floor/{floor}") { deviceStateController.allFloorDeviceState(this.context) }
        get(path = "/building/{building}") { deviceStateController.allBuildingDeviceState(this.context) }
    }
}
