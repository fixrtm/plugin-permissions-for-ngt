/*
 * This file is a file to specify partial signature of CommandSender in `org.bukkit.command` package in Bukkit project.
 * Bukkit is published under GNU GPL 3.0.
 * see https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/LICENCE.txt.
 * Original source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/command/CommandSender.java
 */

package org.bukkit.command;

import compat.Vendor;
import compat.Vendors;
import org.bukkit.permissions.Permissible;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public interface CommandSender extends Permissible {
}
