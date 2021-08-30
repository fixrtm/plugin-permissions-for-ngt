/*
 * This file is a file to specify partial signature of Bukkit in `org.bukkit` package in Bukkit project.
 * Bukkit is published under GNU GPL 3.0.
 * see https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/LICENCE.txt.
 * Original source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/Bukkit.java
 */

package org.bukkit;

public class Bukkit {
    public static Server getServer() {
        throw new IllegalStateException();
    }
}
