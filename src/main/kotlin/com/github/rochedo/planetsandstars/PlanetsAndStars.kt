package com.github.rochedo.planetsandstars

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.github.rochedo.planetsandstars.config.PlanetsAndStarsCustomPlanets
import com.github.rochedo.planetsandstars.recipes.serializers.AlloySmelterRecipeSerializer
import com.github.rochedo.planetsandstars.recipes.types.AlloySmelterRecipeType
import com.github.rochedo.planetsandstars.registry.*
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import com.github.rochedo.planetsandstars.utils.WorldGeneration
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.registry.Registry

object PlanetsAndStars : ModInitializer {
    val PAS_GROUP: ItemGroup = FabricItemGroupBuilder.build(MyIdentifier("general_group")) { ItemStack { Items.IRON_BLOCK.asItem() } }

    override fun onInitialize() {
        // Generate Configs
        PlanetsAndStarsConfigs
        PlanetsAndStarsCustomPlanets

        // Register All Things
        PlanetsAndStarsBlocks.register()
        PlanetsAndStarsDimensions.register()
        PlanetsAndStarsFluids.register()
        PlanetsAndStarsGUIs.register()
        PlanetsAndStarsItems.register()
        WorldGeneration.register()
    }
}
