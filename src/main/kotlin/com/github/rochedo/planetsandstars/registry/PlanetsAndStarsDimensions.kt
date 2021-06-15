package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.registry.dimensions.planets.MercuryChunkGenerator
import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.exceptions.CommandSyntaxException
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarted
import net.minecraft.block.Blocks
import net.minecraft.command.CommandException
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType.COW
import net.minecraft.entity.passive.CowEntity
import net.minecraft.server.MinecraftServer
import net.minecraft.server.command.CommandManager.literal
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.LiteralText
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.TeleportTarget
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions
import net.minecraft.world.dimension.DimensionType


object PlanetsAndStarsDimensions {
    // Mercury
    private val DIMENSION_KEY: RegistryKey<DimensionOptions?>? = RegistryKey.of(
        Registry.DIMENSION_KEY,
        MyIdentifier("void")
    )

    private var WORLD_KEY = RegistryKey.of<World>(
        Registry.WORLD_KEY,
        DIMENSION_KEY!!.value
    )

    private val DIMENSION_TYPE_KEY: RegistryKey<DimensionType> = RegistryKey.of(
        Registry.DIMENSION_TYPE_KEY,
        MyIdentifier("void_type")
    )

    fun register() {
        Registry.register(Registry.CHUNK_GENERATOR, MyIdentifier("void"), MercuryChunkGenerator.CODEC)

        WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, MyIdentifier("void"))

        ServerLifecycleEvents.SERVER_STARTED.register(ServerStarted { server: MinecraftServer ->
            val overworld = server.getWorld(World.OVERWORLD)
            val world = server.getWorld(WORLD_KEY) ?: throw AssertionError("Test world doesn't exist.")
            val entity: CowEntity? = COW.create(overworld)
            if (!entity!!.world.getRegistryKey()
                    .equals(World.OVERWORLD)
            ) throw AssertionError("Entity starting world isn't the overworld")
            val target = TeleportTarget(Vec3d.ZERO, Vec3d(1.0, 1.0, 1.0), 45f, 60f)
            val teleported: Entity = FabricDimensions.teleport(entity, world, target)
                ?: throw AssertionError("Entity didn't teleport")
            if (!teleported.world.getRegistryKey().equals(WORLD_KEY)) throw AssertionError("Target world not reached.")
            if (!teleported.getPos().equals(target.position)) throw AssertionError("Target Position not reached.")
        })

        CommandRegistrationCallback.EVENT.register(
            CommandRegistrationCallback { dispatcher: CommandDispatcher<ServerCommandSource?>, dedicated: Boolean ->
                dispatcher.register(
                    literal("planetsandstars").executes(this@PlanetsAndStarsDimensions::swapTargeted)
                )
            }
        )
    }

    @Throws(CommandSyntaxException::class)
    private fun swapTargeted(context: CommandContext<ServerCommandSource>): Int {
        val player = context.source.player
        val serverWorld = player.serverWorld
        val modWorld: ServerWorld = getModWorld(context)!!
        if (serverWorld !== modWorld) {
            val target = TeleportTarget(Vec3d(0.5, 101.0, 0.5), Vec3d.ZERO, 0F, 0F)
            FabricDimensions.teleport(player, modWorld, target)
            if (player.world !== modWorld) {
                throw CommandException(LiteralText("Teleportation failed!"))
            }
            modWorld.setBlockState(BlockPos(0, 100, 0), Blocks.DIAMOND_BLOCK.defaultState)
            modWorld.setBlockState(BlockPos(0, 101, 0), Blocks.TORCH.defaultState)
        } else {
            val target = TeleportTarget(
                Vec3d(0.0, 100.0, 0.0), Vec3d.ZERO,
                Math.random().toFloat() * 360 - 180, Math.random().toFloat() * 360 - 180
            )
            FabricDimensions.teleport(player, getWorld(context, World.OVERWORLD), target)
        }
        return 1
    }

    private fun getModWorld(context: CommandContext<ServerCommandSource>): ServerWorld? {
        return getWorld(context, WORLD_KEY)
    }

    private fun getWorld(
        context: CommandContext<ServerCommandSource>,
        dimensionRegistryKey: RegistryKey<World>
    ): ServerWorld? {
        return context.source.minecraftServer.getWorld(dimensionRegistryKey)
    }
}