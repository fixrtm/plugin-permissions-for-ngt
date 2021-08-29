package org.bukkit.permissions;

import compat.Vendor;
import compat.Vendors;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public interface Permissible {
    @Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
    boolean hasPermission(String name);
}
