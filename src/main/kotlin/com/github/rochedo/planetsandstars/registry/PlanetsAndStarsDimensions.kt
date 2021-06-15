package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.registry.dimensions.planets.MercuryChunkGenerator
import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import com.mojang.brigadier.context.CommandContext
import com.mojang.serialization.Codec
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions
import net.minecraft.block.Blocks
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.TeleportTarget
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

    fun join(context: CommandContext<ServerCommandSource>): Int {
        val player = context.source.player
        val modWorld: ServerWorld = context.source.minecraftServer.getWorld(WORLD_KEY)!!

        val target = TeleportTarget(Vec3d(0.5, 101.0, 0.5), Vec3d.ZERO, 0.0F, 0.0F)
        FabricDimensions.teleport(player, modWorld, target)
        modWorld.setBlockState(BlockPos(0, 100, 0), Blocks.BEDROCK.defaultState)
        return 1
    }
}