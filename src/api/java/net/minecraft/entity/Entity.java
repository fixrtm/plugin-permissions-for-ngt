/*
 * This file is a file to specify partial signature of Entity in `net.minecraft.entity` package in Minecraft
 * and patched by CraftBukkit project.
 * CraftBukkit is published under GNU GPL 3.0.
 * see https://hub.spigotmc.org/stash/projects/SPIGOT/repos/craftbukkit/browse/LICENCE.txt.
 * Original source(patch): https://hub.spigotmc.org/stash/projects/SPIGOT/repos/craftbukkit/browse/nms-patches/Entity.patch?at=refs%2Fheads%2Fversion%2F1.12.2
 */

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
