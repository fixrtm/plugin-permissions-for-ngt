package net.minecraft.entity;

import compat.Vendor;
import compat.Vendors;

@Vendors({Vendor.MC1710, Vendor.MC1122})
public abstract class Entity {
    //@Vendors({Vendor.MC1710})
    //public abstract org.bukkit.craftbukkit.entity.CraftEntity getBukkitEntity();

    //@Vendors({Vendor.MC1122})
    //public abstract org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity getBukkitEntity();

    // PluginPermsForNgt: common super interface
    public abstract org.bukkit.entity.Entity getBukkitEntity();
}
