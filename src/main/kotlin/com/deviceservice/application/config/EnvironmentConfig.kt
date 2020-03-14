package com.deviceservice.application.config

import com.natpryce.konfig.Configuration
import com.natpryce.konfig.Key
import com.natpryce.konfig.EnvironmentVariables

import com.natpryce.konfig.stringType

object EnvironmentConfig {

    private val config: Configuration = EnvironmentVariables()

    val databaseUrl = config[Key(name = "DATABASE_URL", parse = stringType)]
    val databaseUser = config[Key(name = "DATABASE_USER", parse = stringType)]
    val databasePassword = config[Key(name = "DATABASE_PASSWORD", parse = stringType)]

}
