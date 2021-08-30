package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.*
import java.net.URI

open class DownloadHttpMod : SetupMod() {
    @Input
    val uri = project.objects.property(URI::class)

    @Suppress("LeakingThis")
    private val action = DownloadAction.simple(this, uri::get)

    @TaskAction
    fun execute() = action.download()

    override val targetFile get() = action.targetFile
}
