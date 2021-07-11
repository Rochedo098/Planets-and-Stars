package com.github.rochedo.planetsandstars.gui.rockets

import io.github.cottonmc.cotton.gui.SyncedGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WPlainPanel
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.TranslatableText

class RocketMK1GUI (
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

        val moonButton = WButton(TranslatableText("button.planetsandstars.moon_button"))
        root.add(moonButton, 14, 5, 100, 20)

        val mercuryButton = WButton(TranslatableText("button.planetsandstars.mercury_button"))
        root.add(mercuryButton, 14, 30, 100, 20)

        val venusButton = WButton(TranslatableText("button.planetsandstars.venus_button"))
        root.add(venusButton, 14, 55, 100, 20)
    }
}