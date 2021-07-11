package com.github.rochedo.planetsandstars.registry.blocks.entitys.machines

import com.github.rochedo.planetsandstars.gui.machines.CrusherGUI
import com.github.rochedo.planetsandstars.javapi.ImplementedInventory
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsGUIs
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.item.ItemStack
import net.minecraft.recipe.RecipeInputProvider
import net.minecraft.recipe.RecipeMatcher
import net.minecraft.screen.NamedScreenHandlerFactory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

class CrusherEntity(pos: BlockPos?, state: BlockState?) :
    BlockEntity(PlanetsAndStarsGUIs.CRUSHER_ENTITY, pos, state), ImplementedInventory, NamedScreenHandlerFactory, RecipeInputProvider {
    private val items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)

    override fun getItems(): DefaultedList<ItemStack> {
        return items
    }

    override fun canPlayerUse(player: PlayerEntity): Boolean {
        return pos.isWithinDistance(player.blockPos, 4.5)
    }

    override fun getDisplayName(): Text {
        return LiteralText("Crusher")
    }

    override fun createMenu(syncId: Int, inv: PlayerInventory, player: PlayerEntity): ScreenHandler {
        return CrusherGUI(
            PlanetsAndStarsGUIs.CRUSHER_HANDLER_TYPE,
            syncId,
            inv,
            ScreenHandlerContext.create(world, pos)
        )
    }

    companion object {
        const val INVENTORY_SIZE = 8
    }

    override fun markDirty() {

    }

    override fun provideRecipeInputs(finder: RecipeMatcher?) {
        val var2: Iterator<*> = this.items.iterator()

        while (var2.hasNext()) {
            val itemStack = var2.next() as ItemStack
            finder!!.addUnenchantedInput(itemStack)
        }
    }
}