package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.recipes.serializers.AlloySmelterRecipeSerializer
import com.github.rochedo.planetsandstars.recipes.types.AlloySmelterRecipeType
import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import net.minecraft.util.registry.Registry

object PlanetsAndStarsRecipes {
    fun register() {
        Registry.register(Registry.RECIPE_SERIALIZER, AlloySmelterRecipeSerializer().ID, AlloySmelterRecipeSerializer().INSTANCE)
        Registry.register(Registry.RECIPE_TYPE, MyIdentifier(AlloySmelterRecipeType().ID), AlloySmelterRecipeType().INSTANCE)
    }
}