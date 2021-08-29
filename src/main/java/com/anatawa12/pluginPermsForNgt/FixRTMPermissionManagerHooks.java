package com.anatawa12.pluginPermsForNgt;

import jp.ngt.ngtlib.util.PermissionManager;

public class FixRTMPermissionManagerHooks {
    public static void registerPermission(String permission) {
        ((IPermissionRegister)PermissionManager.INSTANCE).registerPermission(permission);
    }
}
