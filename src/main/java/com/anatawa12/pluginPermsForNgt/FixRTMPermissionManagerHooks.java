/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt;

import jp.ngt.ngtlib.util.PermissionManager;

public class FixRTMPermissionManagerHooks {
    public static void registerPermission(String permission) {
        ((IPermissionRegister)PermissionManager.INSTANCE).registerPermission(permission);
    }
}
