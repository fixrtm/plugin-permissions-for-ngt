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
