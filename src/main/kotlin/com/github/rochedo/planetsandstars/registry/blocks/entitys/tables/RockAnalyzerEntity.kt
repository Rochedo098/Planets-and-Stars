package com.github.rochedo.planetsandstars.registry.blocks.entitys.tables

import com.github.rochedo.planetsandstars.api.ImplementedInventory
import com.github.rochedo.planetsandstars.gui.RockAnalyzerGUI
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsGUIs
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class RockAnalyzerEntity(pos: BlockPos?, state: BlockState?) : BlockEntity(PlanetsAndStarsGUIs.ROCK_ANALYZER_ENTITY, pos, state), ImplementedInventory, NamedScreenHandlerFactory {
    private val items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)

    override fun getItems(): DefaultedList<ItemStack> {
        return items
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory?, player: PlayerEntity?): ScreenHandler? {
        return RockAnalyzerGUI(
            PlanetsAndStarsGUIs.ROCK_ANALYZER_HANDLER_TYPE,
            syncId,
            inv,
            ScreenHandlerContext.create(world, pos)
        )
    }

    override fun getDisplayName(): Text? {
        return null
    }

    override fun markDirty() {
        super<ImplementedInventory>.markDirty()
    }

    companion object {
        const val INVENTORY_SIZE = 8
    }
}