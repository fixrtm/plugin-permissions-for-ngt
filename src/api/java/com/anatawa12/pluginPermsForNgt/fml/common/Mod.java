/*
 * This file is a file to specify existence of Mod.EventHandler in either
 * `cpw.mods.fml.common` or `net.minecraftforge.fml.common` package in Forge Mod Loader project.
 * Forge Mod Loader is published under GNU LGPL 2.1.
 * see https://github.com/MinecraftForge/MinecraftForge/blob/1.12.x/LICENSE.txt and
 * https://github.com/MinecraftForge/MinecraftForge/blob/1.7.10/fml/LICENSE-fml.txt.
 * Original source: https://github.com/MinecraftForge/MinecraftForge/blob/1.12.x/src/main/java/net/minecraftforge/fml/common/Mod.java
 * Original source: https://github.com/MinecraftForge/MinecraftForge/blob/1.7.10/fml/src/main/java/cpw/mods/fml/common/Mod.java
 */
package com.anatawa12.pluginPermsForNgt.fml.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public @interface Mod {
    @Retention(RetentionPolicy.RUNTIME)
    @interface EventHandler{}
}
