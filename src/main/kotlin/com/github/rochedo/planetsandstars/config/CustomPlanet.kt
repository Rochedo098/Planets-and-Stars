package com.github.rochedo.planetsandstars.config

import com.github.rochedo.planetsandstars.api.atmosphere.Composition
import com.github.rochedo.planetsandstars.api.atmosphere.Contaminated
import net.minecraft.block.Block

class CustomPlanet (
    val baseBlock: Block,
    val oreGeneration: Array<Block>,
    val atmosphere: Contaminated,
    val composition: Composition
)