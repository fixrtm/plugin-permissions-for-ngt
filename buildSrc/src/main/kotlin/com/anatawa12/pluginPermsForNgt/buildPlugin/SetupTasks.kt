/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * Currently, This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

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
