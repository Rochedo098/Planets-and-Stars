package com.github.rochedo.planetsandstars.registry

import com.github.rochedo.planetsandstars.registry.fluids.HydrogenFluid
import com.github.rochedo.planetsandstars.registry.fluids.OxygenFluid
import com.github.rochedo.planetsandstars.utils.MyIdentifier
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.block.FluidBlock
import net.minecraft.block.Material
import net.minecraft.fluid.FlowableFluid
import net.minecraft.item.BucketItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.registry.Registry

object PlanetsAndStarsFluids {
    var STILL_OXYGEN: FlowableFluid? = null
    var FLOWING_OXYGEN: FlowableFluid? = null
    var OXYGEN_BUCKET: Item? = null
    var OXYGEN: Block? = null

    var STILL_HYDROGEN: FlowableFluid? = null
    var FLOWING_HYDROGEN: FlowableFluid? = null
    var HYDROGEN_BUCKET: Item? = null
    var HYDROGEN: Block? = null

    fun register() {
        STILL_OXYGEN = Registry.register(Registry.FLUID, MyIdentifier("oxygen"), OxygenFluid.Still())
        FLOWING_OXYGEN = Registry.register(Registry.FLUID, MyIdentifier("flowing_oxygen"), OxygenFluid.Flowing())
        OXYGEN_BUCKET = Registry.register(Registry.ITEM, MyIdentifier("oxygen_bucket"), BucketItem(STILL_OXYGEN, FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)))
        OXYGEN = Registry.register(Registry.BLOCK, MyIdentifier("oxygen"), object : FluidBlock(STILL_OXYGEN, FabricBlockSettings.of(Material.WATER)){})

        STILL_HYDROGEN = Registry.register(Registry.FLUID, MyIdentifier("hydrogen"), HydrogenFluid.Still())
        FLOWING_HYDROGEN = Registry.register(Registry.FLUID, MyIdentifier("flowing_hydrogen"), HydrogenFluid.FLowing())
        HYDROGEN_BUCKET = Registry.register(Registry.ITEM, MyIdentifier("hydrogen_bucket"), BucketItem(STILL_HYDROGEN, FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)))
        HYDROGEN = Registry.register(Registry.BLOCK, MyIdentifier("hydrogen"), object : FluidBlock(STILL_HYDROGEN, FabricBlockSettings.of(Material.WATER)){})
    }
}