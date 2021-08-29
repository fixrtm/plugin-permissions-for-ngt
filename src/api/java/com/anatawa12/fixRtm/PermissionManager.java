package com.anatawa12.fixRtm;

import compat.Vendor;
import compat.Vendors;

@Vendors(Vendor.FixRTM)
public final class PermissionManager {
    public static PermissionManager INSTANCE = new PermissionManager();

    public void registerPermission(String permission) {
        throw new IllegalStateException();
    }
}
