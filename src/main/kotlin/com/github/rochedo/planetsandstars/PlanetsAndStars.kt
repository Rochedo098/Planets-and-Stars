package com.github.rochedo.planetsandstars

import com.github.rochedo.planetsandstars.registry.*
import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object PlanetsAndStars : ModInitializer {
    override fun onInitialize() {
        // Registry
        PlanetsAndStarsArmors.register()
        PlanetsAndStarsBlocks.register()
        PlanetsAndStarsItems.register()
        PlanetsAndStarsFluids.register()
        PlanetsAndStarsGUIs.register()
        PlanetsAndStarsDimensions.register()
    }

    val PAS_GROUP: ItemGroup = FabricItemGroupBuilder.build(MyIdentifier("general_group")) { ItemStack { Items.IRON_BLOCK.asItem() } }
}