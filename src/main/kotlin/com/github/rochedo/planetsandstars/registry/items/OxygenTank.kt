package com.github.rochedo.planetsandstars.registry.items

import com.github.rochedo.planetsandstars.utils.PasItemSettings
import dev.emi.trinkets.api.TrinketItem
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.world.World

class OxygenTank : TrinketItem(PasItemSettings()) {
    val oxygen: Int = 0

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext?
    ) {
        tooltip.add(LiteralText("Oxygen: " + oxygen))
    }
}