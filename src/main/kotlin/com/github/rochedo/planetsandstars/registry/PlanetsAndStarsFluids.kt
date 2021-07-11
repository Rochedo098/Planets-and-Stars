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
    var STILL_OXYGEN: FlowableFluid = OxygenFluid.Still()
    var FLOWING_OXYGEN: FlowableFluid = OxygenFluid.Flowing()
    var OXYGEN_BUCKET: Item = BucketItem(STILL_OXYGEN, FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1))
    var OXYGEN: Block = object : FluidBlock(STILL_OXYGEN, FabricBlockSettings.of(Material.WATER)){}

    var STILL_HYDROGEN: FlowableFluid = HydrogenFluid.Still()
    var FLOWING_HYDROGEN: FlowableFluid = HydrogenFluid.FLowing()
    var HYDROGEN_BUCKET: Item = BucketItem(STILL_HYDROGEN, FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1))
    var HYDROGEN: Block = object : FluidBlock(STILL_HYDROGEN, FabricBlockSettings.of(Material.WATER)){}

    fun register() {
        Registry.register(Registry.FLUID, MyIdentifier("oxygen"), STILL_OXYGEN)
        Registry.register(Registry.FLUID, MyIdentifier("flowing_oxygen"), FLOWING_OXYGEN)
        Registry.register(Registry.ITEM, MyIdentifier("oxygen_bucket"), OXYGEN_BUCKET)
        Registry.register(Registry.BLOCK, MyIdentifier("oxygen"), OXYGEN)

        Registry.register(Registry.FLUID, MyIdentifier("hydrogen"), STILL_HYDROGEN)
        Registry.register(Registry.FLUID, MyIdentifier("flowing_hydrogen"), FLOWING_HYDROGEN)
        Registry.register(Registry.ITEM, MyIdentifier("hydrogen_bucket"), HYDROGEN_BUCKET)
        Registry.register(Registry.BLOCK, MyIdentifier("hydrogen"), HYDROGEN)
    }
}