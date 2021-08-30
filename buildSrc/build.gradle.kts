import kotlin.reflect.cast

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.apache.httpcomponents:httpclient:4.5.13")
}

val buildPlugin by gradlePlugin.plugins.creating {
    id = "plugin-perms-for-ngt-build"
    implementationClass = "com.anatawa12.pluginPermsForNgt.buildPlugin.BuildPlugin"
}

tasks.compileKotlin {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn."
}
