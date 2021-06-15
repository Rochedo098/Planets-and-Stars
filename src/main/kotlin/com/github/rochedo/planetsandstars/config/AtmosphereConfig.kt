package com.github.rochedo.planetsandstars.config

import com.github.rochedo.planetsandstars.api.atmosphere.Contaminated
import com.github.rochedo.planetsandstars.config.custominput.PolutionConfig

class AtmosphereConfig (
    val oxygen_reqired: Int,
    val polution: Array<PolutionConfig>,
    val radioactive: Boolean,
    val contaminated: Contaminated
)