package com.github.rochedo.planetsandstars.registry.blocks.machines

import com.github.rochedo.planetsandstars.recipes.AlloySmelterRecipe
import com.github.rochedo.planetsandstars.recipes.types.AlloySmelterRecipeType
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.AlloySmelterEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.util.*


class AlloySmelterBlock : BlockWithEntity(FabricBlockSettings.copy(Blocks.IRON_BLOCK)) {
    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hitResult: BlockHitResult
    ): ActionResult {
        player.openHandledScreen(state.createScreenHandlerFactory(world, pos))
        return ActionResult.SUCCESS
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity? {
        return AlloySmelterEntity(pos, state)
    }

    override fun getRenderType(state: BlockState): BlockRenderType {
        return BlockRenderType.MODEL
    }

    fun activate(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, result: BlockHitResult): Boolean {
        if (!world.isClient) {
            val inventory: AlloySmelterEntity = AlloySmelterEntity(pos, state)
            val match: Optional<AlloySmelterRecipe> = world.recipeManager.getFirstMatch(AlloySmelterRecipeType().INSTANCE, inventory, world)
            if (match.isPresent) {
                player.inventory.offerOrDrop(ItemStack.EMPTY);
                player.getMainHandStack().decrement(1);
                player.getOffHandStack().decrement(1);
            }
        }
        return true
    }
}
