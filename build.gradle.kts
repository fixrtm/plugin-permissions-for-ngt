plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

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
}
