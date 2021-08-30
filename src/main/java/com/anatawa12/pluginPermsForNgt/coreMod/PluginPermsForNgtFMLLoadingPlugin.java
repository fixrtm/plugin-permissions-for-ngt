/*
 * Copyright (C) 2021 anatawa12 and other contributors
 *
 * This file is/was a part of plugin-permissions-for-ngt,
 * which is released under GNU GPL v3.
 *
 * See LICENSE at https://github.com/anatawa12/plugin-permissions-for-ngt.
 */

package com.anatawa12.pluginPermsForNgt.coreMod;

import java.util.Map;

public class PluginPermsForNgtFMLLoadingPlugin implements net.minecraftforge.fml.relauncher.IFMLLoadingPlugin, cpw.mods.fml.relauncher.IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[] {
            "com.anatawa12.pluginPermsForNgt.coreMod.ClassTransformer",
        };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
