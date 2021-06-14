package com.github.rochedo.planetsandstars.utils

import com.github.rochedo.planetsandstars.PlanetsAndStars
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags
import net.minecraft.block.Material
import net.minecraft.item.Item
import net.minecraft.util.Identifier

object RegistryUtils {
    fun MyIdentifier(name: String): Identifier {
        return Identifier("planetsandstars", name)
    }

    fun PasItemSettings(): Item.Settings {
        return FabricItemSettings().group(PlanetsAndStars.PAS_GROUP)
    }

    fun PasBlockSettings(material: Material, strength: Float): FabricBlockSettings {
        return FabricBlockSettings.of(material).strength(strength)
    }

    fun PasOreSetings(strength: Float, mininglevel: Int): FabricBlockSettings {
        return FabricBlockSettings.of(Material.STONE).strength(strength).breakByTool(FabricToolTags.PICKAXES, mininglevel)
    }
}