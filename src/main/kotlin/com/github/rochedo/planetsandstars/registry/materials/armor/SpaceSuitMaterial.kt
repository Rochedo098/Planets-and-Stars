package com.github.rochedo.planetsandstars.registry.materials.armor

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class SpaceSuitMaterial : ArmorMaterial {
    val durability: IntArray = intArrayOf(13, 15, 12, 11)
    val protection: IntArray = intArrayOf(1, 2, 3, 4)

    override fun getDurability(slot: EquipmentSlot?): Int {
            return durability[slot!!.entitySlotId] * 2
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return protection[slot!!.entitySlotId];
    }

    override fun getEnchantability(): Int {
        return 0
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.EMPTY
    }

    override fun getName(): String {
        return "space"
    }

    override fun getToughness(): Float {
        return 0f
    }

    override fun getKnockbackResistance(): Float {
        return 0f
    }
}
