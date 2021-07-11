package com.github.rochedo.planetsandstars.registry.fluids

import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsFluids
import com.github.rochedo.planetsandstars.registry.fluids.abstract.AbstractOxygenFluid
import net.minecraft.block.BlockState
import net.minecraft.fluid.Fluid
import net.minecraft.fluid.FluidState
import net.minecraft.item.Item
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties

abstract class OxygenFluid : AbstractOxygenFluid() {
    override fun getStill(): Fluid {
        return PlanetsAndStarsFluids.STILL_OXYGEN
    }

    override fun getFlowing(): Fluid {
        return PlanetsAndStarsFluids.FLOWING_OXYGEN
    }

    override fun getBucketItem(): Item {
        return PlanetsAndStarsFluids.OXYGEN_BUCKET
    }

    override fun toBlockState(state: FluidState): BlockState {
        return PlanetsAndStarsFluids.OXYGEN.defaultState.with(Properties.LEVEL_15, getBlockStateLevel(state))
    }

    class Flowing : OxygenFluid() {
        override fun appendProperties(builder: StateManager.Builder<Fluid, FluidState>) {
            super.appendProperties(builder)
            builder.add(LEVEL)
        }

        override fun getLevel(state: FluidState): Int {
            return state.get(LEVEL)
        }

        override fun isStill(state: FluidState?): Boolean {
            return false
        }
    }

    class Still : OxygenFluid() {
        override fun getLevel(state: FluidState?): Int {
            return 8
        }

        override fun isStill(state: FluidState?): Boolean {
            return true
        }
    }
}