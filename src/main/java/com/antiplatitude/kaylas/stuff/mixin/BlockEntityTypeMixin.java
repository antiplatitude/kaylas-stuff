/*
 * Copyright (c) 2022 Antiplatitude
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.antiplatitude.kaylas.stuff.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * BlockEntity types. Borrowed from https://github.com/nyuppo/fabric-sign-example under GPL-3.0
 */
@Mixin(BlockEntityType.class)
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
