/* 
 * This file is a file to specify partial signatures of PermissionManager class in fixRTM.
 * original file: https://github.com/fixrtm/fixRTM/blob/HEAD/src/main/java/com/anatawa12/fixRtm/PermissionManager.kt
 * fixRTM is published under GNU LGPL 3.0 with some exceptions.
 * see https://github.com/fixrtm/fixRTM/blob/master/LICENSE.
 */

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
