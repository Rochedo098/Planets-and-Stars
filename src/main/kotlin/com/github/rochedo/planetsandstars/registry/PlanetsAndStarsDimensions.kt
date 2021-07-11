package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.github.rochedo.planetsandstars.registry.dimensions.moons.EarthMoonChunkGenerator
import com.github.rochedo.planetsandstars.registry.dimensions.planets.*
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import com.mojang.serialization.Codec
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.gen.chunk.ChunkGenerator


object PlanetsAndStarsDimensions {
    // Dimensions Keys
    val MERCURY_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("mercury")
    )

    val VENUS_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("venus")
    )

    val MARS_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("mars")
    )

    val JUPITER_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("jupiter")
    )

    val SATURN_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("saturn")
    )

    val URANUS_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("uranus")
    )

    val NEPTUNE_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("neptune")
    )

    val MOON_DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("moon")
    )

    // World Keys
    val MERCURY_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        MERCURY_DIMENSION_KEY.value
    )

    val VENUS_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        VENUS_DIMENSION_KEY.value
    )

    val MARS_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        MARS_DIMENSION_KEY.value
    )

    val JUPITER_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        JUPITER_DIMENSION_KEY.value
    )

    val SATURN_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        SATURN_DIMENSION_KEY.value
    )

    val URANUS_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        URANUS_DIMENSION_KEY.value
    )

    val NEPTUNE_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        NEPTUNE_DIMENSION_KEY.value
    )

    val MOON_WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        MOON_DIMENSION_KEY.value
    )

    // Dimensions Keys Types
    val MERCURY_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("mercury_type")
    )

    val VENUS_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("venus_type")
    )

    val MARS_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("mars_type")
    )

    val JUPITER_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("jupiter_type")
    )

    val SATURN_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("saturn_type")
    )

    val URANUS_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("uranus_type")
    )

    val NEPTUNE_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("neptune_type")
    )

    val MOON_DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("moon_type")
    )

    fun register() {
        val planetsConfig = PlanetsAndStarsConfigs.planets
        if (planetsConfig.mercury.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("mercury"), MercuryChunkGenerator.CODEC
            )
        }

        if (planetsConfig.venus.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("venus"), VenusChunkGenerator.CODEC
            )
        }

        if (planetsConfig.mars.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("mars"), MarsChunkGenerator.CODEC
            )
        }

        if (planetsConfig.jupiter.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("jupiter"), JupiterChunkGenerator.CODEC
            )
        }

        if (planetsConfig.saturn.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("saturn"), SaturnChunkGenerator.CODEC
            )
        }

        if (planetsConfig.uranus.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("uranus"), UranusChunkGenerator.CODEC
            )
        }

        if (planetsConfig.neptune.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("neptune"), NeptuneChunkGenerator.CODEC
            )
        }

        if (planetsConfig.moon.active) {
            Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
                Registry.CHUNK_GENERATOR, MyIdentifier("moon"), EarthMoonChunkGenerator.CODEC
            )
        }
    }
}