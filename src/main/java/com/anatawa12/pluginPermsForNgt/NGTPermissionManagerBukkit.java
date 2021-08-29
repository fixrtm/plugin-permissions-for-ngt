package com.anatawa12.pluginPermsForNgt;

import compat.Vendor;
import compat.Vendors;
import jp.ngt.ngtlib.io.NGTLog;
import jp.ngt.ngtlib.util.PermissionManager;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import org.bukkit.permissions.Permissible;
import org.bukkit.util.permissions.DefaultPermissions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import static com.anatawa12.pluginPermsForNgt.PluginPermsForNgtMain.PERM_PREFIX;

public class NGTPermissionManagerBukkit extends PermissionManager implements IPermissionRegister {
    public NGTPermissionManagerBukkit() {
        super();
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void save() {
        // nop
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void load() {
        // nop
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public List<String> getPlayerList(String par1) {
        PluginPermsForNgtMain.log("calling getPlayerList by " + new Throwable().getStackTrace()[1]);
        return Collections.emptyList();
    }

    // KaizPatchX
    @Vendors(Vendor.KaizPatch)
    public void registerPermission(String per1) {
        DefaultPermissions.registerPermission(PERM_PREFIX + per1, 
                "The permission of ngtlib permission " + per1);
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void showPermissionList(ICommandSender player) {
        NGTLog.sendChatMessage(player, 
                "It's impossible to show permission list because plugin-permissions-for-ngt is installed");
    }

    // KaizPatchX
    @Vendors(Vendor.KaizPatch)
    public List<String> getPermissionList() {
        PluginPermsForNgtMain.log("calling getPermissionList by " + new Throwable().getStackTrace()[1]);
        return Collections.emptyList();
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void addPermission(ICommandSender player, String targetPlayerName, String category) {
        NGTLog.sendChatMessage(player, "This operation is disabled by plugin-permissions-for-ngt.");
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void removePermission(ICommandSender player, String targetPlayerName, String category) {
        NGTLog.sendChatMessage(player, "This operation is disabled by plugin-permissions-for-ngt.");
    }

    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public boolean hasPermission(ICommandSender player, String category) {
        if (player instanceof Entity) {
            Object bukkitEntity = getBukkitEntity((Entity) player);
            if (bukkitEntity instanceof Permissible) {
                return ((Permissible) bukkitEntity).hasPermission(PERM_PREFIX + category);
            }
        }
        return false;
    }

    private static final Method getBukkitEntity;
    public static Object getBukkitEntity(Entity e) {
        try {
            return getBukkitEntity.invoke(e);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    static {
        try {
            getBukkitEntity = Entity.class.getMethod("getBukkitEntity");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
