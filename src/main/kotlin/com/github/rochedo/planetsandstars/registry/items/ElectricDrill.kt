package com.github.rochedo.planetsandstars.registry.items

import com.github.rochedo.planetsandstars.registry.materials.tool.DrillToolMaterial
import com.github.rochedo.planetsandstars.utils.PasItemSettings
import dev.technici4n.fasttransferlib.api.Simulation
import dev.technici4n.fasttransferlib.api.energy.EnergyIo
import net.minecraft.block.BlockState
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.text.LiteralText
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.TextColor
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionType

class ElectricDrill(
    val maxEnergy: Double,
    val actEnergy: Double,
    val insert: Boolean,
    val extract: Boolean
) : PickaxeItem(DrillToolMaterial(), 3, 1.0f, PasItemSettings()), EnergyIo {
    override fun getEnergyCapacity(): Double {
        return maxEnergy
    }

    override fun getEnergy(): Double {
        return actEnergy
    }

    override fun supportsInsertion(): Boolean {
        return insert
    }

    override fun supportsExtraction(): Boolean {
        return extract
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext?
    ) {
        tooltip.add(LiteralText("This drill only works on space"))
        if (this.energy < 1.9) {
            tooltip.add(LiteralText("The energy is not sufficient").formatted(Formatting.RED))
        }

        if (this.energy < (this.energyCapacity / 3)) {
            tooltip.add(LiteralText("Energy: " + this.energy + "/" + (this.maxEnergy + 0.1)).formatted(Formatting.RED))
        } else if (this.energy < (this.energyCapacity / 2)) {
            tooltip.add(LiteralText("Energy: " + this.energy + "/" + (this.maxEnergy + 0.1)).formatted(Formatting.YELLOW))
        } else {
            tooltip.add(LiteralText("Energy: " + this.energy + "/" + (this.maxEnergy + 0.1)).formatted(Formatting.GREEN))
        }
    }

    override fun postMine(
        stack: ItemStack?,
        world: World?,
        state: BlockState?,
        pos: BlockPos?,
        miner: LivingEntity?
    ): Boolean {
        if (this.energy >= 1.9) {
            this.extract(1.9, Simulation.ACT)
        }
        return true
    }

    override fun canMine(state: BlockState?, world: World, pos: BlockPos?, miner: PlayerEntity): Boolean {
        var returns: Boolean = false
        if (this.energy >= 1.9) {
            returns = true
        }
        return returns
    }
}
