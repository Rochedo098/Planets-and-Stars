package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.registry.blocks.machines.AlloySmelterBlock
import com.github.rochedo.planetsandstars.registry.blocks.machines.CrusherBlock
import com.github.rochedo.planetsandstars.registry.blocks.tables.RocketMK1Block
import com.github.rochedo.planetsandstars.utils.RegistryUtils.MyIdentifier
import com.github.rochedo.planetsandstars.utils.RegistryUtils.PasBlockSettings
import com.github.rochedo.planetsandstars.utils.RegistryUtils.PasItemSettings
import com.github.rochedo.planetsandstars.utils.RegistryUtils.PasOreSetings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

object PlanetsAndStarsBlocks {
    // Machines
    val ALLOY_SMELTER: Block = AlloySmelterBlock()
    val CRUSHER: Block = CrusherBlock()

    // Rockets
    val ROCKET_MK1: Block = RocketMK1Block()

    // Planets Rocks
    val MERCURY_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val VENUS_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val MARS_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val JUPITER_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val SATURN_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val URANUS_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val NEPTUNE_ROCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))

    // Blocks
    val TIN_BLOCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val LEAD_BLOCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val SILVER_BLOCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))
    val STEEL_BLOCK: Block = Block(PasBlockSettings(Material.METAL, 4.0f))

    // Ores
    val TIN_ORE: Block = Block(PasOreSetings(4.0f, 3))
    val LEAD_ORE: Block = Block(PasOreSetings(4.0f, 3))
    val SILVER_ORE: Block = Block(PasOreSetings(4.0f, 3))

    fun register() {
        // Machines
        Registry.register(Registry.BLOCK, MyIdentifier("alloy_smelter"), ALLOY_SMELTER)
        Registry.register(Registry.ITEM,  MyIdentifier("alloy_smelter"), BlockItem(ALLOY_SMELTER, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("crusher"), CRUSHER)
        Registry.register(Registry.ITEM,  MyIdentifier("crusher"), BlockItem(CRUSHER, PasItemSettings()))

        // Planets Rocks
        Registry.register(Registry.BLOCK, MyIdentifier("mercury_rock"), MERCURY_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("mercury_rock"), BlockItem(MERCURY_ROCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("venus_rock"), VENUS_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("venus_rock"), BlockItem(VENUS_ROCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("mars_rock"), MARS_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("mars_rock"), BlockItem(MARS_ROCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("jupiter_rock"), JUPITER_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("jupiter_rock"), BlockItem(JUPITER_ROCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("saturn_rock"), SATURN_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("saturn_rock"), BlockItem(SATURN_ROCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("uranus_rock"), URANUS_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("uranus_rock"), BlockItem(URANUS_ROCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("neptune_rock"), NEPTUNE_ROCK)
        Registry.register(Registry.ITEM,  MyIdentifier("neptune_rock"), BlockItem(NEPTUNE_ROCK, PasItemSettings()))

        // Ores
        Registry.register(Registry.BLOCK, MyIdentifier("tin_ore"), TIN_ORE)
        Registry.register(Registry.ITEM,  MyIdentifier("tin_ore"), BlockItem(TIN_ORE, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("lead_ore"), LEAD_ORE)
        Registry.register(Registry.ITEM,  MyIdentifier("lead_ore"), BlockItem(LEAD_ORE, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("silver_ore"), SILVER_ORE)
        Registry.register(Registry.ITEM,  MyIdentifier("silver_ore"), BlockItem(SILVER_ORE, PasItemSettings()))

        // Blocks
        Registry.register(Registry.BLOCK, MyIdentifier("tin_block"), TIN_BLOCK)
        Registry.register(Registry.ITEM,  MyIdentifier("tin_block"), BlockItem(TIN_BLOCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("lead_block"), LEAD_BLOCK)
        Registry.register(Registry.ITEM,  MyIdentifier("lead_block"), BlockItem(LEAD_BLOCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("silver_block"), SILVER_BLOCK)
        Registry.register(Registry.ITEM,  MyIdentifier("silver_block"), BlockItem(SILVER_BLOCK, PasItemSettings()))

        Registry.register(Registry.BLOCK, MyIdentifier("steel_block"), STEEL_BLOCK)
        Registry.register(Registry.ITEM,  MyIdentifier("steel_block"), BlockItem(STEEL_BLOCK, PasItemSettings()))
    }
}