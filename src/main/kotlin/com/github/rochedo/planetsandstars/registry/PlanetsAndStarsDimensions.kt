package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.registry.dimensions.planets.MercuryChunkGenerator
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import com.mojang.serialization.Codec
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.gen.chunk.ChunkGenerator


object PlanetsAndStarsDimensions {
    val DIMENSION_KEY: RegistryKey<DimensionOptions> = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("mercury")
    )

    val WORLD_KEY: RegistryKey<World> = RegistryKey.of(
        Registry.WORLD_KEY,
        DIMENSION_KEY.value
    )

    val DIMENSION_KEY_TYPE: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("mercury_type")
    )

    fun register() {
        Registry.register<Codec<out ChunkGenerator>, Codec<out ChunkGenerator>>(
            Registry.CHUNK_GENERATOR, MyIdentifier("mercury"), MercuryChunkGenerator.CODEC
        )
    }
}