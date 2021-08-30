package net.minecraftforge.fml.common;

public @interface Mod {
    String modid();
    String name() default "";
    String version() default "";
}
