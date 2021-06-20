package com.github.rochedo.planetsandstars.config.customplanets

import net.minecraft.block.Block

class CustomPlanet (
    val active: Boolean,
    val baseBlock: String,
    val oreGeneration: Array<String>,
    val atmosphere: Atmosphere
)