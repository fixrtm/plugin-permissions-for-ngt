package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.tasks.Internal

interface NameHolder {
    @get:Internal
    var otherName: String
    class Impl : NameHolder {
        override lateinit var otherName: String
    }
}
