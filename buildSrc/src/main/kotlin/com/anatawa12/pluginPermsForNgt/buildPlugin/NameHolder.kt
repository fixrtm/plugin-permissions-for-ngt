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

interface NameHolder {
    @get:Internal
    var otherName: String
    class Impl : NameHolder {
        override lateinit var otherName: String
    }
}
