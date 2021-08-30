package com.anatawa12.pluginPermsForNgt.fml.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public @interface Mod {
    @Retention(RetentionPolicy.RUNTIME)
    @interface EventHandler{}
}
