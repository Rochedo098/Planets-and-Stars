package com.github.rochedo.planetsandstars

import com.github.rochedo.planetsandstars.gui.AlloySmelterGUI
import com.github.rochedo.planetsandstars.gui.CrusherGUI
import com.github.rochedo.planetsandstars.gui.RocketMK1GUI
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsGUIs
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text

object PlanetsAndStarsClient: ClientModInitializer {
    override fun onInitializeClient() {
        ScreenRegistry.register<AlloySmelterGUI, CottonInventoryScreen<AlloySmelterGUI>>(
            PlanetsAndStarsGUIs.ALLOY_SMELTER_HANDLER_TYPE,
            ScreenRegistry.Factory<AlloySmelterGUI, CottonInventoryScreen<AlloySmelterGUI>> { desc: AlloySmelterGUI, inventory: PlayerInventory, title: Text? ->
                CottonInventoryScreen(
                    desc,
                    inventory.player,
                    title
                )
            }
        )

        ScreenRegistry.register<CrusherGUI, CottonInventoryScreen<CrusherGUI>>(
            PlanetsAndStarsGUIs.CRUSHER_HANDLER_TYPE,
            ScreenRegistry.Factory<CrusherGUI, CottonInventoryScreen<CrusherGUI>> { desc: CrusherGUI, inventory: PlayerInventory, title: Text? ->
                CottonInventoryScreen(
                    desc,
                    inventory.player,
                    title
                )
            }
        )

        ScreenRegistry.register<RocketMK1GUI, CottonInventoryScreen<RocketMK1GUI>>(
            PlanetsAndStarsGUIs.ROCKET_MK1_HANDLER_TYPE,
            ScreenRegistry.Factory<RocketMK1GUI, CottonInventoryScreen<RocketMK1GUI>> { desc: RocketMK1GUI, inventory: PlayerInventory, title: Text? ->
                CottonInventoryScreen(
                    desc,
                    inventory.player,
                    title
                )
            }
        )
    }
}