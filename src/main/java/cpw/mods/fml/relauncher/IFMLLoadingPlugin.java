/*
 * This file is a file to provide IFMLLoadingPlugin.class file
 * on minecraft forge 11 or later (for 1.8 or later).
 * Originally this code is by ForgeModLoader.
 * Forge Mod Loader is published under GNU LGPL 2.1.
 * see https://github.com/MinecraftForge/MinecraftForge/blob/1.7.10/fml/LICENSE-fml.txt.
 * Original source: https://github.com/MinecraftForge/MinecraftForge/blob/1.7.10/fml/src/main/java/cpw/mods/fml/relauncher/IFMLLoadingPlugin.java
 */

package cpw.mods.fml.relauncher;

import compat.Vendor;
import compat.Vendors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

@Vendors(Vendor.MC1710)
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
