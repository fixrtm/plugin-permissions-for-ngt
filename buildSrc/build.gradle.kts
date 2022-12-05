/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

import kotlin.reflect.cast

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.apache.httpcomponents:httpclient:4.5.14")
}

val buildPlugin by gradlePlugin.plugins.creating {
    id = "plugin-perms-for-ngt-build"
    implementationClass = "com.anatawa12.pluginPermsForNgt.buildPlugin.BuildPlugin"
}

tasks.compileKotlin {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn."
}
