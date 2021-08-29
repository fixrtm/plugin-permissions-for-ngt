package org.bukkit.entity;

import compat.Vendor;
import compat.Vendors;
import org.bukkit.command.CommandSender;

@Vendors({Vendor.Bukkit1710, Vendor.Bukkit1122})
public interface Entity extends @Vendors(Vendor.Bukkit1122) CommandSender {
}
