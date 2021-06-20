package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.github.rochedo.planetsandstars.registry.materials.armor.SpaceSuitMaterial
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import com.github.rochedo.planetsandstars.utils.PasItemSettings
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object PlanetsAndStarsItems {
    // Resources
    val TIN_INGOT: Item = Item(PasItemSettings())
    val LEAD_INGOT: Item = Item(PasItemSettings())
    val SILVER_INGOT: Item = Item(PasItemSettings())
    val STEEL_INGOT: Item = Item(PasItemSettings())
    val SILICON: Item = Item(PasItemSettings())

    // Raw Ores
    val RAW_TIN: Item = Item(PasItemSettings())
    val RAW_LEAD: Item = Item(PasItemSettings())
    val RAW_SILVER: Item = Item(PasItemSettings())

    // Components
    val BASIC_CIRCUIT: Item = Item(PasItemSettings())
    val ADVANCED_CIRCUIT: Item = Item(PasItemSettings())
    val INDUSTRIAL_CIRCUIT: Item = Item(PasItemSettings())

    // Batterys
    val BASIC_BATTERY: Item = Item(PasItemSettings())
    val ADVANCED_BATTERY: Item = Item(PasItemSettings())
    val INDUSTRIAL_BATTERY: Item = Item(PasItemSettings())

    // Guide
    val GUIDE: Item = Item(PasItemSettings())

    // Armors
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
        Registry.register(Registry.ITEM, MyIdentifier("tin_ingot"), TIN_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("lead_ingot"), LEAD_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("steel_ingot"), STEEL_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("silicon"), SILICON)

        Registry.register(Registry.ITEM, MyIdentifier("raw_tin"), RAW_TIN)
        Registry.register(Registry.ITEM, MyIdentifier("raw_lead"), RAW_LEAD)
        Registry.register(Registry.ITEM, MyIdentifier("raw_silver"), RAW_SILVER)

        Registry.register(Registry.ITEM, MyIdentifier("basic_circuit"), BASIC_CIRCUIT)
        Registry.register(Registry.ITEM, MyIdentifier("advanced_circuit"), ADVANCED_CIRCUIT)
        Registry.register(Registry.ITEM, MyIdentifier("industrial_circuit"), INDUSTRIAL_CIRCUIT)

        Registry.register(Registry.ITEM, MyIdentifier("basic_battery"), BASIC_BATTERY)
        Registry.register(Registry.ITEM, MyIdentifier("advanced_battery"), ADVANCED_BATTERY)
        Registry.register(Registry.ITEM, MyIdentifier("industrial_battery"), INDUSTRIAL_BATTERY)

        Registry.register(Registry.ITEM, MyIdentifier("guide_book"), GUIDE)

        // Armors
        val armorConfig = PlanetsAndStarsConfigs.atmosphere
        if (armorConfig.space_suit.active) {
            Registry.register(Registry.ITEM, MyIdentifier("space_suit_helmet"), SPACE_SUIT_HELMET)
            Registry.register(Registry.ITEM, MyIdentifier("space_suit_chestplate"), SPACE_SUIT_CHESTPLATE)
            Registry.register(Registry.ITEM, MyIdentifier("space_suit_leggings"), SPACE_SUIT_LEGGINGS)
            Registry.register(Registry.ITEM, MyIdentifier("space_suit_boots"), SPACE_SUIT_BOOTS)
        }

        if (armorConfig.thermal_suit.active) {
            Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_helmet"), THERMAL_SUIT_HELMET)
            Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_chestplate"), THERMAL_SUIT_CHESTPLATE)
            Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_leggings"), THERMAL_SUIT_LEGGINGS)
            Registry.register(Registry.ITEM, MyIdentifier("thermal_suit_boots"), THERMAL_SUIT_BOOTS)
        }
    }
}