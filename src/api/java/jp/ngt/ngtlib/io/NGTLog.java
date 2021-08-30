/*
 * This file is a file to specify partial signature of NGTLog in `jp.ngt.ngtlib.io` package in NGTLib project.
 * NGTLib is not open source project.
 */

package jp.ngt.ngtlib.io;

import compat.Vendor;
import compat.Vendors;
import net.minecraft.command.ICommandSender;

/**
 * The version compatible logging library by ngtlib
 */
@Vendors({Vendor.MC1710, Vendor.NGT1122})
public class NGTLog {
    @Vendors({Vendor.MC1710, Vendor.NGT1122})
    public static void sendChatMessage(ICommandSender player, String message, Object... objects) {
    }
}
