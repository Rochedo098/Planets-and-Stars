package com.github.rochedo.planetsandstars.registry.blocks.rockets

import com.github.rochedo.planetsandstars.registry.blocks.entitys.rockets.RocketMK1Entity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class RocketMK1Block: BlockWithEntity(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    override fun onUse(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        player: PlayerEntity,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        player.openHandledScreen(state!!.createScreenHandlerFactory(world, pos))
        return ActionResult.SUCCESS
    }
    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity? {
        return RocketMK1Entity(pos, state)
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }
}