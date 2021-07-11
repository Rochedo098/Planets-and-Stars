package com.github.rochedo.planetsandstars.registry.blocks.rockets

import com.github.rochedo.planetsandstars.registry.blocks.entitys.rockets.RocketMK3Entity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

class RocketMK3Block : BlockWithEntity(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    init {
        defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(Properties.HORIZONTAL_FACING)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return this.defaultState.with(FACING, ctx.playerFacing.opposite)
    }

    override fun onUse(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        player: PlayerEntity?,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        player!!.openHandledScreen(state!!.createScreenHandlerFactory(world, pos))
        return ActionResult.SUCCESS
    }

    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity {
        return RocketMK3Entity(pos, state)
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    companion object {
        val FACING = HorizontalFacingBlock.FACING
    }
}