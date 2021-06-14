package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.gui.AlloySmelterGUI
import com.github.rochedo.planetsandstars.gui.CrusherGUI
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.AlloySmelterEntity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.CrusherEntity
import com.github.rochedo.planetsandstars.utils.RegistryUtils
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object PlanetsAndStarsGUIs {
    // Alloy Smelter
    var ALLOY_SMELTER_ENTITY: BlockEntityType<AlloySmelterEntity>? = null
    var ALLOY_SMELTER_HANDLER_TYPE: ScreenHandlerType<AlloySmelterGUI>? = null

    // Crusher
    var CRUSHER_ENTITY: BlockEntityType<CrusherEntity>? = null
    var CRUSHER_HANDLER_TYPE: ScreenHandlerType<CrusherGUI>? = null

    fun register() {
        // Alloy Smelter
        ALLOY_SMELTER_ENTITY =
            FabricBlockEntityTypeBuilder.create(::AlloySmelterEntity, PlanetsAndStarsBlocks.ALLOY_SMELTER).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, RegistryUtils.MyIdentifier("alloy_smelter_gui"), ALLOY_SMELTER_ENTITY)

        ALLOY_SMELTER_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            RegistryUtils.MyIdentifier("alloy_smelter_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                AlloySmelterGUI(
                    ALLOY_SMELTER_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )

        // Crusher
        CRUSHER_ENTITY = FabricBlockEntityTypeBuilder.create(::CrusherEntity, PlanetsAndStarsBlocks.CRUSHER).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, RegistryUtils.MyIdentifier("crusher_gui"), ALLOY_SMELTER_ENTITY)

        CRUSHER_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            RegistryUtils.MyIdentifier("crusher_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                CrusherGUI(
                    CRUSHER_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )
    }
}