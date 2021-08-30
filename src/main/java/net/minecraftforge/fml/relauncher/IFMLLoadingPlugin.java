/*
 * This file is a file to provide IFMLLoadingPlugin.class file
 * on minecraft forge 10 or earlier (for 1.7 or earlier).
 * Originally this code is by Forge Mod Loader.
 * Forge Mod Loader is published under GNU LGPL 2.1.
 * see https://github.com/MinecraftForge/MinecraftForge/blob/1.12.x/LICENSE.txt.
 * Original source: https://github.com/MinecraftForge/MinecraftForge/blob/1.12.x/src/main/java/net/minecraftforge/fml/relauncher/IFMLLoadingPlugin.java
 */

package net.minecraftforge.fml.relauncher;

import compat.Vendor;
import compat.Vendors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

@Vendors(Vendor.MC1122)
public interface IFMLLoadingPlugin {
    String[] getASMTransformerClass();
    String getModContainerClass();
    String getSetupClass();
    void injectData(Map<String, Object> data);
    String getAccessTransformerClass();

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface TransformerExclusions {
        String[] value() default "";
    }
}
