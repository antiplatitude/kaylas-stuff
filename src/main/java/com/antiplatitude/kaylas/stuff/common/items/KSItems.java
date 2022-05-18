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

package com.antiplatitude.kaylas.stuff.common.items;

import com.antiplatitude.kaylas.stuff.KaylasStuff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * All the Kayla's Stuff items.
 *
 * @author antiplatitude
 */
public class KSItems
{
    /** Default settings for macrame items, placing them in the macrame tab TODO */
    public static final FabricItemSettings MACRAME_SETTINGS = new FabricItemSettings().group(ItemGroup.MISC);

    // Items
    public static final Item MACRAME_CORD = registerItem("macrame_cord", new Item(MACRAME_SETTINGS));
    public static final Item WOOD_RING = registerItem("wood_ring", new Item(MACRAME_SETTINGS));
    public static final Item WOOD_BEAD = registerItem("wood_bead", new Item(MACRAME_SETTINGS));

    /**
     * Registers a new item.
     *
     * @param name The String appended to "kaylasstuff:" used to identify this item
     * @param item Instance of Item with settings added
     * @return The newly created Item
     */
    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registry.ITEM, new Identifier(KaylasStuff.MOD_ID, name), item);
    }

    /**
     * Not quite sure. I suspect invoking this method forces this class to load which initializes the items.
     */
    public static void registerItems()
    {
        KaylasStuff.LOGGER.info("Registering items for " + KaylasStuff.MOD_ID);
    }
}

