/*
 * This file is a file to specify partial signature of Entity in `org.bukkit.entity` package in Bukkit project.
 * Bukkit is published under GNU GPL 3.0.
 * see https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/LICENCE.txt.
 * Original source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/entity/Entity.java
 */

package org.bukkit.entity;

import compat.Vendor;
import compat.Vendors;
import org.bukkit.command.CommandSender;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public interface Entity extends @Vendors(Vendor.Bukkit1122) CommandSender {
}
