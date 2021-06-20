package com.github.rochedo.planetsandstars.recipes.types

import com.github.rochedo.planetsandstars.recipes.AlloySmelterRecipe
import net.minecraft.recipe.RecipeType

class AlloySmelterRecipeType : RecipeType<AlloySmelterRecipe> {
    val INSTANCE: AlloySmelterRecipeType = AlloySmelterRecipeType()
    val ID = "alloy_smelter_recipe"
}