package com.github.rochedo.planetsandstars

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs
import com.github.rochedo.planetsandstars.gui.machines.AlloySmelterGUI
import com.github.rochedo.planetsandstars.gui.machines.CompressorGUI
import com.github.rochedo.planetsandstars.gui.machines.CrusherGUI
import com.github.rochedo.planetsandstars.gui.rockets.RocketMK1GUI
import com.github.rochedo.planetsandstars.gui.rockets.RocketMK2GUI
import com.github.rochedo.planetsandstars.gui.rockets.RocketMK3GUI
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsGUIs
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry
import net.minecraft.client.option.KeyBinding
import net.minecraft.client.util.InputUtil
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.text.Text
import org.lwjgl.glfw.GLFW

object PlanetsAndStarsClient: ClientModInitializer {
    var DARK_HELMET_UP: KeyBinding? = null
    var DARK_HELMET_DOWN: KeyBinding? = null

    override fun onInitializeClient() {
        // Register Keys
        DARK_HELMET_UP = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "key.planetsandstars.dark_helmet_up",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                "category.planetsandstars.general_group"
            )
        )

        DARK_HELMET_DOWN = KeyBindingHelper.registerKeyBinding(
            KeyBinding(
                "key.planetsandstars.dark_helmet_down",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                "category.planetsandstars.general_group"
            )
        )

        val machinesConfig = PlanetsAndStarsConfigs.machines
        if (machinesConfig.alloySmelter.active) {
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
        }

        if (machinesConfig.crusher.active) {
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
        }

        if (machinesConfig.compressor.active) {
            ScreenRegistry.register<CompressorGUI, CottonInventoryScreen<CompressorGUI>>(
                PlanetsAndStarsGUIs.COMPRESSOR_HANDLER_TYPE,
                ScreenRegistry.Factory<CompressorGUI, CottonInventoryScreen<CompressorGUI>> { desc: CompressorGUI, inventory: PlayerInventory, title: Text? ->
                    CottonInventoryScreen(
                        desc,
                        inventory.player,
                        title
                    )
                }
            )
        }

        if (machinesConfig.rocketMk1.active) {
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

        if (machinesConfig.rocketMk2.active) {
            ScreenRegistry.register<RocketMK2GUI, CottonInventoryScreen<RocketMK2GUI>>(
                PlanetsAndStarsGUIs.ROCKET_MK2_HANDLER_TYPE,
                ScreenRegistry.Factory<RocketMK2GUI, CottonInventoryScreen<RocketMK2GUI>> { desc: RocketMK2GUI, inventory: PlayerInventory, title: Text? ->
                    CottonInventoryScreen(
                        desc,
                        inventory.player,
                        title
                    )
                }
            )
        }

        if (machinesConfig.rocketMk3.active) {
            ScreenRegistry.register<RocketMK3GUI, CottonInventoryScreen<RocketMK3GUI>>(
                PlanetsAndStarsGUIs.ROCKET_MK3_HANDLER_TYPE,
                ScreenRegistry.Factory<RocketMK3GUI, CottonInventoryScreen<RocketMK3GUI>> { desc: RocketMK3GUI, inventory: PlayerInventory, title: Text? ->
                    CottonInventoryScreen(
                        desc,
                        inventory.player,
                        title
                    )
                }
            )
        }
    }
}
