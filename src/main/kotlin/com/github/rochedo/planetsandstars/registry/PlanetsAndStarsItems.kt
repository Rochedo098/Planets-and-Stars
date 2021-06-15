package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import com.github.rochedo.planetsandstars.utils.RegistryUtils.PasItemSettings
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object PlanetsAndStarsItems {
    // Resources
    val TIN_INGOT: Item = Item(PasItemSettings())
    val LEAD_INGOT: Item = Item(PasItemSettings())
    val SILVER_INGOT: Item = Item(PasItemSettings())
    val STEEL_INGOT: Item = Item(PasItemSettings())
    val SILICON: Item = Item(PasItemSettings())

    // Easter Egg
    val FORGE_TRASH: Item = Item(PasItemSettings())

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

    fun register() {
        Registry.register(Registry.ITEM, MyIdentifier("tin_ingot"), TIN_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("lead_ingot"), LEAD_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("silver_ingot"), SILVER_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("steel_ingot"), STEEL_INGOT)
        Registry.register(Registry.ITEM, MyIdentifier("silicon"), SILICON)

        Registry.register(Registry.ITEM, MyIdentifier("forge_trash"), FORGE_TRASH)

        Registry.register(Registry.ITEM, MyIdentifier("basic_circuit"), BASIC_CIRCUIT)
        Registry.register(Registry.ITEM, MyIdentifier("advanced_circuit"), ADVANCED_CIRCUIT)
        Registry.register(Registry.ITEM, MyIdentifier("industrial_circuit"), INDUSTRIAL_CIRCUIT)

        Registry.register(Registry.ITEM, MyIdentifier("basic_battery"), BASIC_BATTERY)
        Registry.register(Registry.ITEM, MyIdentifier("advanced_battery"), ADVANCED_BATTERY)
        Registry.register(Registry.ITEM, MyIdentifier("industrial_battery"), INDUSTRIAL_BATTERY)

        Registry.register(Registry.ITEM, MyIdentifier("guide_book"), GUIDE)
    }
}