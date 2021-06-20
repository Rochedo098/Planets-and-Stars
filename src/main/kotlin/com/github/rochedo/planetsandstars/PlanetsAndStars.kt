package com.github.rochedo.planetsandstars

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.github.rochedo.planetsandstars.config.PlanetsAndStarsCustomPlanets
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsBlocks
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsDimensions
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsGUIs
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsItems
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object PlanetsAndStars : ModInitializer {
    override fun onInitialize() {
        // Generate Configs
        PlanetsAndStarsConfigs
        PlanetsAndStarsCustomPlanets

        // Register All Things
        PlanetsAndStarsBlocks.register()
        PlanetsAndStarsDimensions.register()
        PlanetsAndStarsGUIs.register()
        PlanetsAndStarsItems.register()

        // Register Recipes
        //Registry.register(Registry.RECIPE_SERIALIZER, AlloySmelterRecipeSerializer().ID, AlloySmelterRecipeSerializer().INSTANCE)
        //Registry.register(Registry.RECIPE_TYPE, RegistryUtils.MyIdentifier(AlloySmelterRecipeType().ID), AlloySmelterRecipeType().INSTANCE)
    }

    val PAS_GROUP: ItemGroup = FabricItemGroupBuilder.build(MyIdentifier("general_group")) { ItemStack { Items.IRON_BLOCK.asItem() } }
}
