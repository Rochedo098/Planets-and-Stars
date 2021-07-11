package com.github.rochedo.planetsandstars.recipes.serializers

import com.github.rochedo.planetsandstars.recipes.AlloySmelterRecipe
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import com.google.gson.Gson
import com.google.gson.JsonObject
import net.minecraft.item.ItemStack
import net.minecraft.network.PacketByteBuf
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

class AlloySmelterRecipeSerializer : RecipeSerializer<AlloySmelterRecipe> {
    val ID: Identifier = MyIdentifier("alloy_smelter_recipe")

    override fun read(id: Identifier, json: JsonObject): AlloySmelterRecipe {
        val recipeJson: AlloySmelterRecipe.Format = Gson().fromJson(json, AlloySmelterRecipe.Format::class.java)
        val inputA: Ingredient = Ingredient.fromJson(recipeJson.inputA)
        val inputB: Ingredient = Ingredient.fromJson(recipeJson.inputB)
        val outputItem = Registry.ITEM.getOrEmpty(Identifier(recipeJson.outputItem)).get()
        val output = ItemStack(outputItem, recipeJson.outputAmount)
        return AlloySmelterRecipe(inputA, inputB, output, id)
    }

    override fun write(buf: PacketByteBuf, recipe: AlloySmelterRecipe) {
        recipe.getInputA().write(buf)
        recipe.getInputB().write(buf)
        buf.writeItemStack(recipe.output)
    }

    override fun read(id: Identifier, buf: PacketByteBuf): AlloySmelterRecipe {
        val inputA: Ingredient = Ingredient.fromPacket(buf)
        val inputB: Ingredient = Ingredient.fromPacket(buf)
        val output: ItemStack = buf.readItemStack()
        return AlloySmelterRecipe(inputA, inputB, output, id)
    }

    companion object {
        val INSTANCE: AlloySmelterRecipeSerializer = AlloySmelterRecipeSerializer()
    }
}
