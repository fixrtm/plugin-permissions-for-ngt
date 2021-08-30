/*
 * This file is a file to specify partial signature of Permissible in `org.bukkit.permissions` package in Bukkit project.
 * Bukkit is published under GNU GPL 3.0.
 * see https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/LICENCE.txt.
 * Original source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/permissions/Permissible.java
 */

package org.bukkit.permissions;

import compat.Vendor;
import compat.Vendors;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public interface Permissible {
    @Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
    boolean hasPermission(String name);
}
