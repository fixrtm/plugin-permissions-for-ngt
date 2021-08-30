/*
 * This file is a file to specify partial signature of DefaultPermissions in `org.bukkit.util.permissions` package in Bukkit project.
 * Bukkit is published under GNU GPL 3.0.
 * see https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/LICENCE.txt.
 * Original source: https://hub.spigotmc.org/stash/projects/SPIGOT/repos/bukkit/browse/src/main/java/org/bukkit/util/permissions/DefaultPermissions.java
 */

package org.bukkit.util.permissions;

import compat.Vendor;
import compat.Vendors;
import org.bukkit.permissions.Permission;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public class DefaultPermissions {
    @Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
    public static Permission registerPermission(String name, String desc) {
        throw new IllegalStateException();
    }
}
