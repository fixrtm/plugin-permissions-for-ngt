/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.*
import org.gradle.kotlin.dsl.*
import org.gradle.work.*
import java.io.File
import java.nio.file.Files

open class RunServer : JavaExec() {
    init {
        group = "run server"
        outputs.upToDateWhen { false }
    }

    @Internal
    val server = project.objects.property(SetupServer::class)
    @Internal
    val mods = project.objects.setProperty(SetupMod::class)
    @Internal
    val plugins = project.objects.setProperty(SetupMod::class)

    @Internal
    val runsOn = project.objects.directoryProperty()

    @Input
    val runsOnPath = runsOn.map { it.asFile.path }
    @Incremental
    @InputFile
    val serverFile = server.flatMap(SetupServer::targetFile)
    @Incremental
    @InputFiles
    val modFiles: FileCollection = project.files(mods.map { it.map(SetupMod::targetFile) })
    @Incremental
    @InputFiles
    val pluginFiles: FileCollection = project.files(plugins.map { it.map(SetupMod::targetFile) })

    init {
        dependsOn(server)
        dependsOn(mods)
        dependsOn(plugins)
    }

    @TaskAction
    fun exec(changes: InputChanges) {
        println("isIncremental: ${changes.isIncremental}")
        val runDir = runsOn.asFile.get()

        copy(runDir, changes.getFileChanges(serverFile))
        linkSymlink(runDir.resolve("mods"), changes.getFileChanges(modFiles))
        linkSymlink(runDir.resolve("plugins"), changes.getFileChanges(pluginFiles))

        workingDir = runDir
        classpath(runDir.resolve(serverFile.get().asFile.name))
        runDir.resolve("eula.txt").writeText("eula=true\n")

        standardInput = System.`in`
        super.exec()
    }

    private fun linkSymlink(directory: File, fileChanges: Iterable<FileChange>) {
        directory.mkdirs()
        for (fileChange in fileChanges) {
            when (fileChange.changeType) {
                ChangeType.ADDED,
                ChangeType.MODIFIED,
                -> {
                    Files.deleteIfExists(directory.resolve(fileChange.file.name).toPath())
                    Files.createSymbolicLink(directory.resolve(fileChange.file.name).toPath(),
                        fileChange.file.toPath())
                }
                ChangeType.REMOVED -> {
                    Files.delete(directory.resolve(fileChange.file.name).toPath())
                }
            }
        }
    }

    private fun copy(directory: File, fileChanges: Iterable<FileChange>) {
        directory.mkdirs()
        for (fileChange in fileChanges) {
            when (fileChange.changeType) {
                ChangeType.ADDED,
                ChangeType.MODIFIED,
                -> {
                    Files.deleteIfExists(directory.resolve(fileChange.file.name).toPath())
                    Files.copy(fileChange.file.toPath(), directory.resolve(fileChange.file.name).toPath())
                }
                ChangeType.REMOVED -> {
                    Files.delete(directory.resolve(fileChange.file.name).toPath())
                }
            }
        }
    }

    override fun exec() {
        // make nop
    }
}
