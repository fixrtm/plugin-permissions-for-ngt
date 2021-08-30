package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.OutputFile

abstract class SetupMod : DefaultTask(), NameHolder by NameHolder.Impl() {
    init {
        group = "setup mod"
    }
    @get:OutputFile
    abstract val targetFile: Provider<RegularFile>
}
abstract class SetupServer : DefaultTask(), NameHolder by NameHolder.Impl() {
    init {
        group = "setup server"
    }
    @get:OutputFile
    abstract val targetFile: Provider<RegularFile>
}
