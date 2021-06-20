package com.github.rochedo.planetsandstars.registry.materials.tool

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class DrillToolMaterial : ToolMaterial {
    override fun getDurability(): Int {
        return 0
    }

    override fun getMiningSpeedMultiplier(): Float {
        return 5.0f
    }

    override fun getAttackDamage(): Float {
        return 3.0f
    }

    override fun getMiningLevel(): Int {
        return 2
    }

    override fun getEnchantability(): Int {
        return 0
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.EMPTY
    }
}