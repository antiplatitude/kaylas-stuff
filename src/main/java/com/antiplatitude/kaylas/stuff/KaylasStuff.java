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

package com.antiplatitude.kaylas.stuff;

import com.antiplatitude.kaylas.stuff.common.items.KSItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A Minecraft mod for version 1.18.2 adding stuff that Kayla likes.
 *
 * @author antiplatitude
 */
public class KaylasStuff implements ModInitializer
{
    public static final String MOD_ID = "kaylasstuff";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize()
    {
        KSItems.registerItems();
    }
}
