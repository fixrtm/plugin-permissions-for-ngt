/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.*
import java.net.URI

open class DownloadMohistServer : SetupServer() {
    @Input
    val version = project.objects.property(String::class)
    @Input
    val buildNumber = project.objects.property(Int::class)

    @Suppress("LeakingThis")
    private val action = DownloadAction.simple(this) {
        URI("https://mohistmc.com/api/${version.get()}/${buildNumber.get()}/download")
    }

    @TaskAction
    fun execute() = action.download()

    override val targetFile get() = action.targetFile
}
