package com.github.rochedo.planetsandstars.gui

import com.github.rochedo.planetsandstars.utils.RegistryUtils
import io.github.cottonmc.cotton.gui.SyncedGuiDescription
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WItemSlot
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType

class AlloySmelterGUI(
    type: ScreenHandlerType<*>?,
    syncId: Int,
    playerInventory: PlayerInventory?,
    context: ScreenHandlerContext?
) :
    SyncedGuiDescription(type, syncId, playerInventory, getBlockInventory(context, 8), null) {
    companion object {
        private val TEST_MESSAGE = RegistryUtils.MyIdentifier("test")
        private val UNREGISTERED_ON_SERVER = RegistryUtils.MyIdentifier("unregistered_on_server")
    }

    init {
        // Create Panel
        val root = WGridPanel()
        setRootPanel(root)
        root.setSize(128, 128)

        val slot = WItemSlot.of(blockInventory, 0, 2, 1)
        root.add(slot, 4, 3, 8, 8)

        val slot1 = WItemSlot.of(blockInventory, 0, 1, 1)
        root.add(slot1, 8, 3, 8, 8)

        root.add(this.createPlayerInventoryPanel(), 1, 1)
        root.validate(this)
    }
}