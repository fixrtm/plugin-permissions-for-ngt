/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.bundling.AbstractArchiveTask
import org.gradle.kotlin.dsl.*

open class ModByArchiveTask : SetupMod() {
    @Internal
    val sourceTask = project.objects.property(AbstractArchiveTask::class)

    init {
        dependsOn(sourceTask)
    }

    override val targetFile get() = sourceTask.flatMap { it.archiveFile }
}
