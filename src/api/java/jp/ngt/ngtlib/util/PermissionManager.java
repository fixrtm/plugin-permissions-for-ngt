package jp.ngt.ngtlib.util;

import compat.Vendor;
import compat.Vendors;
import net.minecraft.command.ICommandSender;

import java.io.IOException;
import java.util.List;

// The file only for signatures
@Vendors({Vendor.NGT1710, Vendor.NGT1122})
// non-final by PluginPermsForNgt
public class PermissionManager {
    public static final PermissionManager INSTANCE = new PermissionManager();

    // PluginPermsForNgt: it will be protected by transformer
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    //private PermissionManager() {
    protected PermissionManager() {
    }

    // The function to save permissions
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void save() {
    }

    // The function to load permissions
    @SuppressWarnings("RedundantThrows")
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void load() throws IOException {
    }

    // the function to get list of players the permission have
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public List<String> getPlayerList(String permission) {
        throw new IllegalStateException();
    }

    // the function to register permission for completion
    @Vendors(Vendor.KaizPatch)
    public void registerPermission(String per1) {
        throw new IllegalStateException();
    }

    // the function to get print list of people how has permission
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void showPermissionList(ICommandSender player) {
    }

    // KaizPatchX: returns list of permissions for completion
    @Vendors(Vendor.KaizPatch)
    public List<String> getPermissionList() {
        throw new IllegalStateException();
    }

    // the function to grant specified permission to targetPlayerName
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void addPermission(ICommandSender player, String targetPlayerName, String category) {
    }

    // the function to revoke specified permission from targetPlayerName
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public void removePermission(ICommandSender player, String targetPlayerName, String category) {
    }

    // the function to check if the CommandSender has permission $category
    @Vendors({Vendor.NGT1710, Vendor.NGT1122})
    public boolean hasPermission(ICommandSender player, String category) {
        throw new IllegalStateException();
    }

}
