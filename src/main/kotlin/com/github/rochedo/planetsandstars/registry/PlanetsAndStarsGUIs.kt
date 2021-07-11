package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.gui.machines.AlloySmelterGUI
import com.github.rochedo.planetsandstars.gui.machines.CompressorGUI
import com.github.rochedo.planetsandstars.gui.machines.CrusherGUI
import com.github.rochedo.planetsandstars.gui.rockets.RocketMK1GUI
import com.github.rochedo.planetsandstars.gui.rockets.RocketMK2GUI
import com.github.rochedo.planetsandstars.gui.rockets.RocketMK3GUI
import com.github.rochedo.planetsandstars.gui.tables.RockAnalyzerGUI
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.AlloySmelterEntity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.CompressorEntity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.machines.CrusherEntity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.rockets.RocketMK1Entity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.rockets.RocketMK2Entity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.rockets.RocketMK3Entity
import com.github.rochedo.planetsandstars.registry.blocks.entitys.tables.RockAnalyzerEntity
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.registry.Registry

object PlanetsAndStarsGUIs {
    // Alloy Smelter
    var ALLOY_SMELTER_ENTITY: BlockEntityType<AlloySmelterEntity>? = null
    var ALLOY_SMELTER_HANDLER_TYPE: ScreenHandlerType<AlloySmelterGUI>? = null

    // Crusher
    var CRUSHER_ENTITY: BlockEntityType<CrusherEntity>? = null
    var CRUSHER_HANDLER_TYPE: ScreenHandlerType<CrusherGUI>? = null

    // Compressor
    var COMPRESSOR_ENTITY: BlockEntityType<CompressorEntity>? = null
    var COMPRESSOR_HANDLER_TYPE: ScreenHandlerType<CompressorGUI>? = null

    // Rocket MK1
    var ROCKET_MK1_ENTITY: BlockEntityType<RocketMK1Entity>? = null
    var ROCKET_MK1_HANDLER_TYPE: ScreenHandlerType<RocketMK1GUI>? = null

    // Rocket MK2
    var ROCKET_MK2_ENTITY: BlockEntityType<RocketMK2Entity>? = null
    var ROCKET_MK2_HANDLER_TYPE: ScreenHandlerType<RocketMK2GUI>? = null

    // Rocket MK3
    var ROCKET_MK3_ENTITY: BlockEntityType<RocketMK3Entity>? = null
    var ROCKET_MK3_HANDLER_TYPE: ScreenHandlerType<RocketMK3GUI>? = null

    // Rock Analyzer
    var ROCK_ANALYZER_ENTITY: BlockEntityType<RockAnalyzerEntity>? = null
    var ROCK_ANALYZER_HANDLER_TYPE: ScreenHandlerType<RockAnalyzerGUI>? = null

    fun register() {
        // Alloy Smelter
        ALLOY_SMELTER_ENTITY =
            FabricBlockEntityTypeBuilder.create(::AlloySmelterEntity, PlanetsAndStarsBlocks.ALLOY_SMELTER).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("alloy_smelter_gui"), ALLOY_SMELTER_ENTITY)

        ALLOY_SMELTER_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("alloy_smelter_gui"),
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
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("crusher_gui"), CRUSHER_ENTITY)

        CRUSHER_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("crusher_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                CrusherGUI(
                    CRUSHER_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )

        // Compressor
        COMPRESSOR_ENTITY = FabricBlockEntityTypeBuilder.create(::CompressorEntity, PlanetsAndStarsBlocks.COMPRESSOR).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("compressor"), COMPRESSOR_ENTITY)

        COMPRESSOR_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("compressor_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                CompressorGUI(
                    COMPRESSOR_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )

        // Rocket MK1
        ROCKET_MK1_ENTITY = FabricBlockEntityTypeBuilder.create(::RocketMK1Entity, PlanetsAndStarsBlocks.ROCKET_MK1).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("rocket_mk1"), ROCKET_MK1_ENTITY)

        ROCKET_MK1_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("rocket_mk1_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                RocketMK1GUI(
                    ROCKET_MK1_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )

        ROCKET_MK2_ENTITY = FabricBlockEntityTypeBuilder.create(::RocketMK2Entity, PlanetsAndStarsBlocks.ROCKET_MK2).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("rocket_mk2"), ROCKET_MK2_ENTITY)

        ROCKET_MK2_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("rocket_mk2_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                RocketMK2GUI(
                    ROCKET_MK2_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )

        ROCKET_MK3_ENTITY = FabricBlockEntityTypeBuilder.create(::RocketMK3Entity, PlanetsAndStarsBlocks.ROCKET_MK3).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("rocket_mk3"), ROCKET_MK3_ENTITY)

        ROCKET_MK3_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("rocket_mk3_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                RocketMK3GUI(
                    ROCKET_MK3_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )

        // Rock Analyzer
        ROCK_ANALYZER_ENTITY = FabricBlockEntityTypeBuilder.create(::RockAnalyzerEntity, PlanetsAndStarsBlocks.ROCK_ANALYZER).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, MyIdentifier("rock_analyzer"), ROCK_ANALYZER_ENTITY)

        ROCK_ANALYZER_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
            MyIdentifier("rock_analyzer_gui"),
            SimpleClientHandlerFactory { syncId: Int, inventory: PlayerInventory? ->
                RockAnalyzerGUI(
                    ROCK_ANALYZER_HANDLER_TYPE,
                    syncId,
                    inventory,
                    ScreenHandlerContext.EMPTY
                )
            }
        )
    }
}
