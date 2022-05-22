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

package com.antiplatitude.kaylas.stuff.block;

import com.antiplatitude.kaylas.stuff.KaylasStuff;
import com.antiplatitude.kaylas.stuff.block.entity.KSSignTypes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

/**
 * All the Kayla's Stuff blocks.
 *
 * @author antiplatitude
 */
public class KSBlocks
{
    // Blocks
    // TODO map colors temporarily set to those of oak logs
    public static final Block MAGNOLIA_LOG = registerBlock(
            "magnolia_log",
            createLogBlock(MapColor.OAK_TAN, MapColor.SPRUCE_BROWN),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block MAGNOLIA_PLANKS = registerBlock(
            "magnolia_planks", new Block(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F, 3.0F)
                                                            .sounds(BlockSoundGroup.WOOD)), ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_MAGNOLIA_LOG = registerBlock(
            "stripped_magnolia_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN), ItemGroup.BUILDING_BLOCKS);

    public static final Block MAGNOLIA_WOOD = registerBlock(
            "magnolia_wood", new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F)
                                                                .sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block STRIPPED_MAGNOLIA_WOOD = registerBlock(
            "stripped_magnolia_wood", new PillarBlock(FabricBlockSettings.copy(MAGNOLIA_WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    public static final Block MAGNOLIA_LEAVES = registerBlock(
            "magnolia_leaves", createLeavesBlock(BlockSoundGroup.GRASS), ItemGroup.DECORATIONS);

    public static final Block MAGNOLIA_DOOR = registerBlock(
            "magnolia_door", new DoorBlock(
                    FabricBlockSettings.of(Material.WOOD, MAGNOLIA_PLANKS.getDefaultMapColor()).strength(3.0F)
                                       .sounds(BlockSoundGroup.WOOD).nonOpaque()), ItemGroup.REDSTONE);

    public static final Block MAGNOLIA_STAIRS = registerBlock(
            "magnolia_stairs", new StairsBlock(
                    MAGNOLIA_PLANKS.getDefaultState(),
                    FabricBlockSettings.copy(MAGNOLIA_PLANKS)), ItemGroup.BUILDING_BLOCKS);

    public static final Block MAGNOLIA_WALL_SIGN_BLOCK = registerBlockWithoutItem(
            "magnolia_wall_sign", new WallSignBlock(
                    FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN),
                    KSSignTypes.MAGNOLIA));

    public static final Block MAGNOLIA_SIGN_BLOCK = registerBlockWithoutItem("magnolia_sign", new SignBlock(
            FabricBlockSettings.copy(Blocks.OAK_SIGN),
            KSSignTypes.MAGNOLIA));

    public static final Block MAGNOLIA_PRESSURE_PLATE = registerBlock(
            "magnolia_pressure_plate", new PressurePlateBlock(
                    PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.of(Material.WOOD, MAGNOLIA_PLANKS.getDefaultMapColor()).noCollision()
                                       .strength(0.5F).sounds(BlockSoundGroup.WOOD)), ItemGroup.REDSTONE);

    public static final Block MAGNOLIA_FENCE = registerBlock(
            "magnolia_fence", new FenceBlock(
                    FabricBlockSettings.of(Material.WOOD, MAGNOLIA_PLANKS.getDefaultMapColor()).strength(2.0F, 3.0F)
                                       .sounds(BlockSoundGroup.WOOD)), ItemGroup.DECORATIONS);

    public static final Block MAGNOLIA_TRAPDOOR = registerBlock(
            "magnolia_trapdoor", new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);

    public static final Block MAGNOLIA_FENCE_GATE = registerBlock(
            "magnolia_fence_gate", new FenceGateBlock(
                    FabricBlockSettings.of(Material.WOOD, MAGNOLIA_PLANKS.getDefaultMapColor()).strength(2.0F, 3.0F)
                                       .sounds(BlockSoundGroup.WOOD)), ItemGroup.REDSTONE);

    public static final Block MAGNOLIA_BUTTON = registerBlock(
            "magnolia_button", new WoodenButtonBlock(
                    FabricBlockSettings.of(Material.DECORATION).noCollision().strength(0.5F)
                                       .sounds(BlockSoundGroup.WOOD)), ItemGroup.REDSTONE);

    public static final Block MAGNOLIA_SLAB = registerBlock(
            "magnolia_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F, 3.0F)
                                                              .sounds(BlockSoundGroup.WOOD)),
            ItemGroup.BUILDING_BLOCKS);

    /**
     * Direct rip of Minecraft's createLogBlock since that one is private.
     *
     * @param topMapColor  The MapColor of the stump side
     * @param sideMapColor The MapColor of the bark side
     *
     * @return A new PillarBlock of log style
     */
    private static PillarBlock createLogBlock(MapColor topMapColor, MapColor sideMapColor)
    {
        return new PillarBlock(FabricBlockSettings.of(Material.WOOD, (state) -> {
            return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }

    /**
     * Direct rip of Minecraft's createLeavesBlock since that one is private.
     * TODO spawning set to false for now
     *
     * @param soundGroup The BlockSoundGroup of the leaf (probably always grass)
     *
     * @return A new LeavesBlock
     */
    private static LeavesBlock createLeavesBlock(BlockSoundGroup soundGroup)
    {
        return new LeavesBlock(
                FabricBlockSettings.copy(Blocks.OAK_LEAVES).sounds(soundGroup));
    }

    /**
     * Registers a new Block and its corresponding BlockItem.
     *
     * @param name  The String appended to "kaylasstuff:" used to identify this block
     * @param block Instance of Block with settings added
     * @param group The ItemGroup this item appears under in creative mode
     *
     * @return The newly created Block
     */
    private static Block registerBlock(String name, Block block, ItemGroup group)
    {
        Registry.register(
                Registry.ITEM, new Identifier(KaylasStuff.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(
                        group)));
        return Registry.register(Registry.BLOCK, new Identifier(KaylasStuff.MOD_ID, name), block);
    }

    /**
     * Registers a new Block WITHOUT a corresponding BlockItem.
     *
     * @param name  The String appended to "kaylasstuff:" used to identify this block
     * @param block Instance of Block with settings added
     *
     * @return The newly created Block
     */
    private static Block registerBlockWithoutItem(String name, Block block)
    {
        return Registry.register(Registry.BLOCK, new Identifier(KaylasStuff.MOD_ID, name), block);
    }

    /**
     * Not quite sure. I suspect invoking this method forces this class to load which initializes the blocks.
     */
    public static void registerBlocks()
    {
        KaylasStuff.LOGGER.info("Registering blocks for " + KaylasStuff.MOD_ID);
    }
}
