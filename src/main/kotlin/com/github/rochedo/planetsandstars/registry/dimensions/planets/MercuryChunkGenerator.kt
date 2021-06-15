package com.github.rochedo.planetsandstars.registry.dimensions.planets

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


class MercuryChunkGenerator private constructor (
    biomeSource: BiomeSource, biomeSource2: BiomeSource, private val genSeed: Long,
    private val settings: () -> ChunkGeneratorSettings, private val biomeRegistry: Registry<Biome>
): ChunkGenerator (biomeSource, biomeSource2, settings().structuresConfig, genSeed) {
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
        val CODEC: Codec<MercuryChunkGenerator> = RecordCodecBuilder.create<MercuryChunkGenerator>(
            Function<RecordCodecBuilder.Instance<MercuryChunkGenerator>, App<RecordCodecBuilder.Mu<MercuryChunkGenerator>, MercuryChunkGenerator>> { instance: RecordCodecBuilder.Instance<MercuryChunkGenerator> ->
                instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(MercuryChunkGenerator::getBiomeSource),
                    Codec.LONG.fieldOf("seed").stable().forGetter(MercuryChunkGenerator::genSeed),
                    ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings")
                        .forGetter { Supplier { it.settings() } },
                    RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter(MercuryChunkGenerator::biomeRegistry)
                )
                    .apply(
                        instance,
                        instance.stable(Function4 { biomeSource, seed, genSettings, registry ->
                            MercuryChunkGenerator(
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