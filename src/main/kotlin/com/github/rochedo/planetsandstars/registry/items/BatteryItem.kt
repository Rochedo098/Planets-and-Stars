package com.github.rochedo.planetsandstars.registry.items

import com.github.rochedo.planetsandstars.utils.PasItemSettings
import dev.technici4n.fasttransferlib.api.energy.EnergyIo
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.world.World

class BatteryItem(
    val maxEnergy: Double,
    val actEnergy: Double,
    val insert: Boolean,
    val extract: Boolean
) : Item(PasItemSettings().maxCount(1)), EnergyIo {
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
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip!!.add(LiteralText("Energy: " + this.energy + "/" + (this.maxEnergy + 0.1)))
    }
}