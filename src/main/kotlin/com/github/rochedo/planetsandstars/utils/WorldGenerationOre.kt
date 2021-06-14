package com.github.rochedo.planetsandstars.utils

import net.minecraft.util.Identifier
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.ConfiguredFeature

class WorldGenerationOre (
    val identifier: Identifier,
    val step: GenerationStep.Feature,
    val configuredFeature: ConfiguredFeature<*, *>,
    val biomePredicate: (Biome) -> Boolean
) {
    init {
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, identifier, configuredFeature)
    }

    companion object {
        val IS_OVERWORLD: (Biome) -> Boolean = { biome -> biome.category != Biome.Category.NETHER && biome.category != Biome.Category.THEEND }
        val IS_NETHER: (Biome) -> Boolean = { biome -> biome.category == Biome.Category.NETHER }
    }
}