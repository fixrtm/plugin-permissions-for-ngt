package org.bukkit.command;

import compat.Vendor;
import compat.Vendors;
import org.bukkit.permissions.Permissible;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public interface CommandSender extends Permissible {
}
