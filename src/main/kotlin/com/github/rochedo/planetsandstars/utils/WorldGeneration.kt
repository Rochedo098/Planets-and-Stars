package com.github.rochedo.planetsandstars.utils

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsBlocks
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.decorator.RangeDecoratorConfig
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.heightprovider.UniformHeightProvider

object WorldGeneration {
    private val oresConfig = PlanetsAndStarsConfigs.ores

    val TIN_ORE_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
        .configure(OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            PlanetsAndStarsBlocks.TIN_ORE.defaultState,
            oresConfig.tinOre.size
        ))
        .range(RangeDecoratorConfig(
            UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
        ))
        .spreadHorizontally()
        .repeat(oresConfig.tinOre.rarity)
    //

    val LEAD_ORE_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
        .configure(OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            PlanetsAndStarsBlocks.LEAD_ORE.defaultState,
            oresConfig.leadOre.size
        ))
        .range(RangeDecoratorConfig(
            UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
        ))
        .spreadHorizontally()
        .repeat(oresConfig.leadOre.rarity)
    //

    val SILVER_ORE_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
        .configure(OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            PlanetsAndStarsBlocks.SILVER_ORE.defaultState,
            oresConfig.silverOre.size
        ))
        .range(RangeDecoratorConfig(
            UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))
        ))
        .spreadHorizontally()
        .repeat(oresConfig.silverOre.rarity)
    //

    fun register() {
        if (oresConfig.tinOre.active) {
            val tinOreOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, MyIdentifier("tin_ore_overworld"))
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinOreOverworld.value, TIN_ORE_OVERWORLD)
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, tinOreOverworld)
        }

        if (oresConfig.leadOre.active) {
            val leadOreOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, MyIdentifier("lead_ore_overworld"))
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, leadOreOverworld.value, LEAD_ORE_OVERWORLD)
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, leadOreOverworld)
        }

        if (oresConfig.silverOre.active) {
            val silverOreOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, MyIdentifier("silver_ore_overworld"))
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, silverOreOverworld.value, SILVER_ORE_OVERWORLD)
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, silverOreOverworld)
        }
    }
}