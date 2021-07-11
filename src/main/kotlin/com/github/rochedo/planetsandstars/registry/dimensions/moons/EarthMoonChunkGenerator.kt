package com.github.rochedo.planetsandstars.registry.dimensions.moons

import com.mojang.datafixers.kinds.App
import com.mojang.datafixers.util.Function4
import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.util.dynamic.RegistryLookupCodec
import net.minecraft.util.registry.Registry
import net.minecraft.world.ChunkRegion
import net.minecraft.world.HeightLimitView
import net.minecraft.world.Heightmap
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.source.BiomeSource
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.gen.StructureAccessor
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings
import net.minecraft.world.gen.chunk.VerticalBlockSample
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Function
import java.util.function.Supplier

class EarthMoonChunkGenerator private constructor (
    biomeSource: BiomeSource, biomeSource2: BiomeSource, private val genSeed: Long,
    private val settings: () -> ChunkGeneratorSettings, private val biomeRegistry: Registry<Biome>
): ChunkGenerator(biomeSource, biomeSource2, settings().structuresConfig, genSeed) {
    constructor(
        biomeSource: BiomeSource,
        l: Long,
        settings: () -> ChunkGeneratorSettings,
        registry: Registry<Biome>
    ) : this (
        biomeSource,
        biomeSource,
        l,
        settings,
        registry
    )

    override fun getCodec(): Codec<out ChunkGenerator> {
        return CODEC
    }

    override fun withSeed(seed: Long): ChunkGenerator {
        return this
    }

    override fun buildSurface(region: ChunkRegion?, chunk: Chunk?) {

    }

    override fun populateNoise(
        executor: Executor?,
        accessor: StructureAccessor?,
        chunk: Chunk?
    ): CompletableFuture<Chunk> {
        return CompletableFuture.completedFuture(chunk)
    }

    override fun getHeight(x: Int, z: Int, heightmap: Heightmap.Type?, world: HeightLimitView?): Int {
        return 0
    }

    override fun getColumnSample(x: Int, z: Int, world: HeightLimitView?): VerticalBlockSample {
        return VerticalBlockSample(0, arrayOfNulls(0))
    }

    companion object {
        val CODEC: Codec<EarthMoonChunkGenerator> = RecordCodecBuilder.create<EarthMoonChunkGenerator>(
            Function<RecordCodecBuilder.Instance<EarthMoonChunkGenerator>, App<RecordCodecBuilder.Mu<EarthMoonChunkGenerator>, EarthMoonChunkGenerator>> { instance: RecordCodecBuilder.Instance<EarthMoonChunkGenerator> ->
                instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(EarthMoonChunkGenerator::getBiomeSource),
                    Codec.LONG.fieldOf("seed").stable().forGetter(EarthMoonChunkGenerator::genSeed),
                    ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings")
                        .forGetter { Supplier { it.settings() } },
                    RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter(EarthMoonChunkGenerator::biomeRegistry)
                )
                    .apply(
                        instance,
                        instance.stable(Function4 { biomeSource, seed, genSettings, registry ->
                            EarthMoonChunkGenerator(
                                biomeSource,
                                seed,
                                { genSettings.get() },
                                registry
                            )
                        })
                    )
            }
        )
    }
}