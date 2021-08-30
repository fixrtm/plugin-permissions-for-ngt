package com.anatawa12.pluginPermsForNgt.buildPlugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.add("pluginPermsForNgt", PluginPermsForNgtExtension(target))
    }
}
