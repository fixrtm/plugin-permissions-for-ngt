/*
 * This file is a file to specify partial signature of Mod in 
 * `net.minecraftforge.fml.common` package in Forge Mod Loader project.
 * Forge Mod Loader is published under GNU LGPL 2.1.
 * see https://github.com/MinecraftForge/MinecraftForge/blob/1.12.x/LICENSE.txt and
 * Original source: https://github.com/MinecraftForge/MinecraftForge/blob/1.12.x/src/main/java/net/minecraftforge/fml/common/Mod.java
 */

package net.minecraftforge.fml.common;

public @interface Mod {
    String modid();
    String name() default "";
    String version() default "";
    String acceptableRemoteVersions() default "";
}
