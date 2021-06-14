package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.registry.materials.armor.SpaceSuitMaterial
import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import com.github.rochedo.planetsandstars.utils.RegistryUtils.PasItemSettings
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object PlanetsAndStarsArmors {
    val SPACE_SUIT_MATERIAL: ArmorMaterial = SpaceSuitMaterial()
    val SPACE_SUIT_HELMET: Item = ArmorItem(SPACE_SUIT_MATERIAL, EquipmentSlot.HEAD, PasItemSettings())
    val SPACE_SUIT_CHESTPLATE: Item = ArmorItem(SPACE_SUIT_MATERIAL, EquipmentSlot.CHEST, PasItemSettings())
    val SPACE_SUIT_LEGGINGS: Item = ArmorItem(SPACE_SUIT_MATERIAL, EquipmentSlot.LEGS, PasItemSettings())
    val SPACE_SUIT_BOOTS: Item = ArmorItem(SPACE_SUIT_MATERIAL, EquipmentSlot.FEET, PasItemSettings())

    val THERMAL_SUIT_MATERIAL: ArmorMaterial = SpaceSuitMaterial()
    val THERMAL_SUIT_HELMET: Item = ArmorItem(THERMAL_SUIT_MATERIAL, EquipmentSlot.HEAD, PasItemSettings())
    val THERMAL_SUIT_CHESTPLATE: Item = ArmorItem(THERMAL_SUIT_MATERIAL, EquipmentSlot.CHEST, PasItemSettings())
    val THERMAL_SUIT_LEGGINGS: Item = ArmorItem(THERMAL_SUIT_MATERIAL, EquipmentSlot.LEGS, PasItemSettings())
    val THERMAL_SUIT_BOOTS: Item = ArmorItem(THERMAL_SUIT_MATERIAL, EquipmentSlot.FEET, PasItemSettings())

    fun register() {
        Registry.register(Registry.ITEM, MyIdentifier("space_suit_helmet"), SPACE_SUIT_HELMET)
        Registry.register(Registry.ITEM, MyIdentifier("space_suit_chestplate"), SPACE_SUIT_CHESTPLATE)
        Registry.register(Registry.ITEM, MyIdentifier("space_suit_leggings"), SPACE_SUIT_LEGGINGS)
        Registry.register(Registry.ITEM, MyIdentifier("space_suit_boots"), SPACE_SUIT_BOOTS)

        Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_helmet"), THERMAL_SUIT_HELMET)
        Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_chestplate"), THERMAL_SUIT_CHESTPLATE)
        Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_leggings"), THERMAL_SUIT_LEGGINGS)
        Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_boots"), THERMAL_SUIT_BOOTS)
    }
}