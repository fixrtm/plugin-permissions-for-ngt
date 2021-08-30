/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

class PluginPermsForNgtExtension(project: Project) {
    val mods = project.taskContainer(SetupMod::class, "setupMod")
        .register(DownloadCurseMod::class)
        .register(DownloadHttpMod::class)
        .register(ModByArchiveTask::class)
        .build()
    val servers = project.taskContainer(SetupServer::class, "setupServer")
        .register(DownloadMohistServer::class)
        .build()
    val runs = project.container(RunServer::class) { name ->
        project.tasks.create(name, RunServer::class)
    }
}
