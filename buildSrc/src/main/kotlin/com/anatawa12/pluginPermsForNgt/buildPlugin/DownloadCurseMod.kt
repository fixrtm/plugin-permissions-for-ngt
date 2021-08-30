package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.apache.http.client.methods.HttpGet
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.*
import java.net.URI

open class DownloadCurseMod : SetupMod() {
    @Input
    val projectId = project.objects.property(Int::class)
    @Input
    val fileId = project.objects.property(Int::class)

    @Suppress("LeakingThis")
    private val action = DownloadAction(this) { client ->
        client.executeWithStatusCheck(HttpGet("https://addons-ecs.forgesvc.net/api/v2/" +
                "addon/${projectId.get()}/file/${fileId.get()}/download-url"))
            .entity
            .content
            .use { it.reader().readText() }
            .let(::URI)
    }

    @TaskAction
    fun execute() = action.download()

    override val targetFile get() = action.targetFile
}
