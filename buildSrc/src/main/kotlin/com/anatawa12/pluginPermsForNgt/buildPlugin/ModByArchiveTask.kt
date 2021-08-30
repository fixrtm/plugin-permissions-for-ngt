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
