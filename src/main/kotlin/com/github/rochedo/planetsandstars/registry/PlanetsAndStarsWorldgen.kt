package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.utils.RegistryUtils
import com.github.rochedo.planetsandstars.utils.WorldGenerationOre
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig

object PlanetsAndStarsWorldgen {
    fun init() {
            val copper_generation =
            WorldGenerationOre(
                RegistryUtils.MyIdentifier("tin_ore"),
                GenerationStep.Feature.UNDERGROUND_ORES,
                Feature.ORE.configure(
                    OreFeatureConfig(
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        PlanetsAndStarsBlocks.COPPER_ORE.defaultState,
                        10
                    )
                )
                    .uniformRange(YOffset.getBottom(), YOffset.fixed(48))
                    .spreadHorizontally()
                    .repeat(14),
                WorldGenerationOre.IS_OVERWORLD
            )
    }
}