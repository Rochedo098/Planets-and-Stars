package com.github.rochedo.planetsandstars.gui.rockets

import io.github.cottonmc.cotton.gui.SyncedGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WPlainPanel
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.TranslatableText

class RocketMK2GUI (
    type: ScreenHandlerType<*>?,
    syncId: Int,
    playerInventory: PlayerInventory?,
    context: ScreenHandlerContext?
) : SyncedGuiDescription(type, syncId, playerInventory, getBlockInventory(context, 8), null) {
    init {
        // Create Panel
        val root = WPlainPanel()
        setRootPanel(root)
        root.setSize(128, 128)

        val marsButton = WButton(TranslatableText("button.planetsandstars.mars_button"))
        root.add(marsButton, 14, 5, 100, 20)

        val jupiterButton = WButton(TranslatableText("button.planetsandstars.jupiter_button"))
        root.add(jupiterButton, 14, 30, 100, 20)
    }
}