package com.antiplatitude.kaylas.stuff.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntityType.class)
/**
 * BlockEntity types. Borrowed from https://github.com/nyuppo/fabric-sign-example under GPL-3.0
 */
public class BlockEntityTypeMixin
{
    @Inject(method = "supports", at = @At("HEAD"), cancellable = true)
    private void supports(BlockState state, CallbackInfoReturnable<Boolean> info)
    {
        if (BlockEntityType.SIGN.equals(this) && (
                state.getBlock() instanceof SignBlock || state.getBlock() instanceof WallSignBlock))
        {
            info.setReturnValue(true);
        }
    }
}
