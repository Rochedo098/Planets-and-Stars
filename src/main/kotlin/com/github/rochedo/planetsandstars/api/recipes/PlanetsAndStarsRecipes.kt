package com.github.rochedo.planetsandstars.api.recipes

import com.github.rochedo.planetsandstars.api.recipes.formats.ShapedRecipeFormat
import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import net.minecraft.recipe.Recipe
import java.io.File

object PlanetsAndStarsRecipes {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    private fun generateRecipe(type: RecipeType, file: String, write: Any) {
        var recipeType: String? = null
        when(type) {
            RecipeType.SHAPED -> recipeType = "shaped/"
            RecipeType.SHAPLESS -> recipeType = "shapless/"
            RecipeType.SMELTING -> recipeType = "smelting/"
        }

        val folder = File("resources/data/pas/recipes/" + recipeType)
        if(!folder.exists()) {
            try {
                folder.mkdirs()
            } catch (e: Exception) {
                println("Could not create recipes, future problem is possible")
            }
        }

        val fi = File(folder, file + ".json")
        if (!fi.exists()) {
            fi.createNewFile()
            fi.writeText(gson.toJson(write))
        }
    }

    private fun jsonToObject(type: String, identifier: String): JsonObject {
        return JsonParser().parse("\"" + type + "\":\"" + identifier + "\"" ).asJsonObject
    }

    fun register() {
        val SHAPED   = RecipeType.SHAPED
        val SHAPLESS = RecipeType.SHAPLESS
        val SMELTING = RecipeType.SMELTING

        generateRecipe(SHAPED, "basic_circuit", ShapedRecipeFormat("minecraft:crafting_shaped", arrayOf("SSS", "SSS", "SSS"), jsonToObject("item", "minecraft:iron_block"), jsonToObject("item", "planetsandstars:basic_circuit")))
    }
}