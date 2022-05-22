package com.antiplatitude.kaylas.stuff.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SignType.class)
/**
 * For creating new sign types. Borrowed from https://github.com/nyuppo/fabric-sign-example under GPL-3.0
 */
public interface SignTypeAccessor
{
    @Invoker("<init>")
    static SignType newSignType(String name)
    {
        throw new AssertionError();
    }

    @Invoker("register")
    static SignType registerNew(SignType type)
    {
        throw new AssertionError();
    }
}
