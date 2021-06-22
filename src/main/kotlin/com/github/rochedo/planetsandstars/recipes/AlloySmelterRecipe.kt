package com.github.rochedo.planetsandstars.recipes

import com.github.rochedo.planetsandstars.recipes.serializers.AlloySmelterRecipeSerializer
import com.github.rochedo.planetsandstars.recipes.types.AlloySmelterRecipeType
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsBlocks
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.AlloySmelterEntity
import com.google.gson.JsonObject
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.Recipe
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.world.World

class AlloySmelterRecipe (
    private val inputA: Ingredient,
    private val inputB: Ingredient,
    private val outputStack: ItemStack,
    private val id: Identifier
): Recipe<AlloySmelterEntity> {
    fun getInputA(): Ingredient {
        return inputA
    }

    fun getInputB(): Ingredient {
        return inputB
    }

    override fun matches(inventory: AlloySmelterEntity, world: World?): Boolean {
        return this.inputA.test(inventory.getStack(0)) && inputB.test(inventory.getStack(1))
    }

    override fun craft(inventory: AlloySmelterEntity): ItemStack {
        val itemStack: ItemStack = this.outputStack.copy()
        val nbt: NbtCompound? = inventory.getStack(0).tag
        if (nbt != null) {
            itemStack.tag = nbt.copy()
        }
        return itemStack
    }

    override fun fits(width: Int, height: Int): Boolean {
        return false
    }

    override fun getOutput(): ItemStack {
        return outputStack
    }

    override fun createIcon(): ItemStack {
        return ItemStack(PlanetsAndStarsBlocks.ALLOY_SMELTER)
    }

    override fun getId(): Identifier {
        return id
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return AlloySmelterRecipeSerializer().INSTANCE
    }

    override fun getType(): RecipeType<*> {
        return AlloySmelterRecipeType().INSTANCE
    }

    class Format (
        val inputA: JsonObject,
        val inputB: JsonObject,
        val outputItem: String,
        val outputAmount: Int
    )
}