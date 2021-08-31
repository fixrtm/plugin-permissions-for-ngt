/*
 * This file is a file to specify signatures of Mod in
 * `cpw.mods.fml.common` package in Forge Mod Loader project.
 * Forge Mod Loader is published under GNU LGPL 2.1.
 * see https://github.com/MinecraftForge/MinecraftForge/blob/1.7.10/fml/LICENSE-fml.txt.
 * Original source: https://github.com/MinecraftForge/MinecraftForge/blob/1.7.10/fml/src/main/java/cpw/mods/fml/common/Mod.java
 */

package cpw.mods.fml.common;

public @interface Mod {
    String modid();
    String name() default "";
    String version() default "";
    String acceptableRemoteVersions() default "";
}
