package com.github.rochedo.planetsandstars.registry.blocks.entitys.rockets

import com.github.rochedo.planetsandstars.api.ImplementedInventory
import com.github.rochedo.planetsandstars.gui.RocketMK2GUI
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

class RocketMK2Entity(pos: BlockPos?, state: BlockState?) : BlockEntity(PlanetsAndStarsGUIs.ROCKET_MK2_ENTITY, pos, state), ImplementedInventory, NamedScreenHandlerFactory {
    private val items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)

    override fun getItems(): DefaultedList<ItemStack> {
        return items
    }

    override fun canPlayerUse(player: PlayerEntity?): Boolean {
        return pos.isWithinDistance(player!!.blockPos, 4.5)
    }

    override fun getDisplayName(): Text {
        return LiteralText("Rocket MK2")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory?, player: PlayerEntity?): ScreenHandler? {
        return RocketMK2GUI(
            PlanetsAndStarsGUIs.ROCKET_MK2_HANDLER_TYPE,
            syncId,
            inv,
            ScreenHandlerContext.create(world, pos)
        )
    }

    override fun markDirty() {
        super<ImplementedInventory>.markDirty()
    }

    companion object {
        const val INVENTORY_SIZE = 8
    }
}