/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

import com.anatawa12.pluginPermsForNgt.buildPlugin.*
import java.net.URI

plugins {
    java
    `plugin-perms-for-ngt-build`
    id("com.anatawa12.compile-time-constant") version "1.0.5"
}

group = "com.anatawa12.fixRtm.plugin-permissions-for-ngt"
version = property("version").toString()

val api by sourceSets.creating

repositories {
    mavenCentral()
    maven(url = "https://libraries.minecraft.net/")
}

dependencies {
    implementation(api.output)
    compileOnly("net.minecraft:launchwrapper:1.12")
}

tasks.jar {
    manifest.attributes("FMLCorePlugin" to "com.anatawa12.pluginPermsForNgt.coreMod.PluginPermsForNgtFMLLoadingPlugin")
    manifest.attributes("FMLCorePluginContainsFMLMod" to "*")
}

tasks.createCompileTimeConstant {
    constantsClass = "com.anatawa12.pluginPermsForNgt.Constants"
    values(mapOf("VERSION" to version.toString()))
}

val fixRTMId = 365235
val rtmId = 288988
val ngtlibId = 288989

// minecraft modifications
// KaizPatchX: 1.3.0
val kaizPatch by pluginPermsForNgt.mods.creatingURI(URI("https://github.com/Kai-Z-JP/KaizPatchX/releases/download/" +
        "v1.3.0/src1.7.10_20200822+KaizPatchX-1.3.0.jar"))
// fixRTM: SNAPSHOT-2021-08-15-06-27-14.jar
val fixRTM by pluginPermsForNgt.mods.creatingCurse(fixRTMId, 3425891)

// RTM: 1.7.10.41
val rtm1710 by pluginPermsForNgt.mods.creatingCurse(rtmId, 3039063)
// RTM: 2.4.22-40
val rtm1122 by pluginPermsForNgt.mods.creatingCurse(rtmId, 3387261)

// NGTLib: 1.7.10.32
val ngtlib1710 by pluginPermsForNgt.mods.creatingCurse(ngtlibId, 2940833)
// NGTLib: 2.4.19-35
val ngtlib1122 by pluginPermsForNgt.mods.creatingCurse(ngtlibId, 3387256)

// LuckPerms: v5.3.64
val luckPermsBuildNumber = 1363
val luckPermsVersion = "5.3.64"
val luckPerms1710 by pluginPermsForNgt.mods.creatingURI(URI("https://ci.lucko.me/job/LuckPerms/$luckPermsBuildNumber/artifact" +
        "/bukkit-legacy/loader/build/libs/LuckPerms-Bukkit-Legacy-$luckPermsVersion.jar"))
val luckPerms1122 by pluginPermsForNgt.mods.creatingURI(URI("https://ci.lucko.me/job/LuckPerms/$luckPermsBuildNumber/artifact" +
        "/bukkit/loader/build/libs/LuckPerms-Bukkit-$luckPermsVersion.jar"))

// servers
val mohist1710 by pluginPermsForNgt.servers.creatingMohist("1.7.10", 40)
val mohist1122 by pluginPermsForNgt.servers.creatingMohist("1.12.2", 248)

// others
val pluginPermsForNGT by pluginPermsForNgt.mods.creatingByArchiveTask(tasks.jar)

// base run directory
val runsDir = layout.projectDirectory.dir("runs")

// run configurations
val runSimple1710 by pluginPermsForNgt.runs.creating {
    runsOn.set(runsDir.dir("simple1710"))
    server.set(mohist1710)
    mods.addAll(rtm1710, ngtlib1710, pluginPermsForNGT)
    plugins.addAll(luckPerms1710)
}

val runSimple1122 by pluginPermsForNgt.runs.creating {
    runsOn.set(runsDir.dir("simple1122"))
    server.set(mohist1122)
    mods.addAll(rtm1122, ngtlib1122, pluginPermsForNGT)
    plugins.addAll(luckPerms1122)
}

val runKaizPatch by pluginPermsForNgt.runs.creating {
    runsOn.set(runsDir.dir("kaizPatch"))
    server.set(mohist1710)
    mods.addAll(kaizPatch, pluginPermsForNGT)
    plugins.addAll(luckPerms1710)
}

val runFixRTM by pluginPermsForNgt.runs.creating {
    runsOn.set(runsDir.dir("fixRTM"))
    server.set(mohist1122)
    mods.addAll(rtm1122, ngtlib1122, fixRTM, pluginPermsForNGT)
    plugins.addAll(luckPerms1122)
}
