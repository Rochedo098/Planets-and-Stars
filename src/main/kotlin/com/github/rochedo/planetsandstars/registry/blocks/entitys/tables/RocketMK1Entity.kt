package com.github.rochedo.planetsandstars.registry.blocks.entitys.tables

import com.github.rochedo.planetsandstars.api.ImplementedInventory
import com.github.rochedo.planetsandstars.gui.RocketMK1GUI
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsGUIs
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class RocketMK1Entity(pos: BlockPos?, state: BlockState?) : BlockEntity(PlanetsAndStarsGUIs.ROCKET_MK1_ENTITY, pos, state), ImplementedInventory, NamedScreenHandlerFactory {
    override fun getItems(): DefaultedList<ItemStack> {
        return DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)
    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        return pos.isWithinDistance(player!!.blockPos, 4.5)
    }

    override fun getDisplayName(): Text {
        return LiteralText("Rocket MK1")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory?, player: PlayerEntity?): ScreenHandler? {
        return RocketMK1GUI(
            PlanetsAndStarsGUIs.ROCKET_MK1_HANDLER_TYPE,
            syncId,
            inv,
            ScreenHandlerContext.create(world, pos)
        )
    }

    companion object {
        const val INVENTORY_SIZE = 8
    }

    override fun markDirty() {
        super<ImplementedInventory>.markDirty()
    }
}