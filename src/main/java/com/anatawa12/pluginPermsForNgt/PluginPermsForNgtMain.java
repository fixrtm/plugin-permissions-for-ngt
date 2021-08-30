package com.anatawa12.pluginPermsForNgt;

import jp.ngt.ngtlib.util.PermissionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.anatawa12.pluginPermsForNgt.PluginPermsForNgtMain.MODID;
import static com.anatawa12.pluginPermsForNgt.PluginPermsForNgtMain.NAME;

@net.minecraftforge.fml.common.Mod(modid = MODID, name = NAME)
@cpw.mods.fml.common.Mod(modid = MODID, name = NAME)
public class PluginPermsForNgtMain {
    public static final String MODID = "plugin-permissions-for-ngt";
    public static final String NAME = "plugin permissions for ngt";
    private static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final String PERM_PREFIX = "ngt-permissions.";

    public static void log(String body) {
        LOGGER.info("[" + MODID + "]: " + body);
    }

    @com.anatawa12.pluginPermsForNgt.fml.common.Mod.EventHandler
    public void postInit(com.anatawa12.pluginPermsForNgt.fml.common.event.FMLPostInitializationEvent event) {
        ((IPermissionRegister)PermissionManager.INSTANCE).onPostInit();
    }
}
