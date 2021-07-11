package com.github.rochedo.planetsandstars.gui.rockets

import io.github.cottonmc.cotton.gui.SyncedGuiDescription
import io.github.cottonmc.cotton.gui.widget.WButton
import io.github.cottonmc.cotton.gui.widget.WGridPanel
import io.github.cottonmc.cotton.gui.widget.WPlainPanel
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.TranslatableText

class RocketMK3GUI (
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

        val saturnButton = WButton(TranslatableText("button.planetsandstars.saturn_button"))
        root.add(saturnButton, 14, 5, 100, 20)

        val uranusButton = WButton(TranslatableText("button.planetsandstars.uranus_button"))
        root.add(uranusButton, 14, 30, 100, 20)

        val neptuneButton = WButton(TranslatableText("button.planetsandstars.neptune_button"))
        root.add(neptuneButton, 14, 55, 100, 20)
    }
}