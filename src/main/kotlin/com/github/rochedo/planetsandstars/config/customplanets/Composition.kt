package com.github.rochedo.planetsandstars.config.customplanets

import com.github.rochedo.planetsandstars.config.PlanetsAndStarsConfigs

class Composition(
    Hydrogen: Int,
    Helium: Int,
    CarbonDioxide: Int,
    Nitrogen: Int,
    Oxygen: Int,
    Argon: Int,
    Methane: Int,
    Radioactive: Boolean
) {
    private val hydrogen = Hydrogen
    private val helium = Helium
    private val carbon = CarbonDioxide
    private val nitrogen = Nitrogen
    private val oxygen = Oxygen
    private val argon = Argon
    private val methane = Methane
    private val radioactive = Radioactive

    fun requireOxygenTank(): Boolean {
        var require: Boolean? = false
        if(oxygen >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_oxygen) {
            require = true
        }
        return require!!
    }

    fun isPolluted(): Boolean {
        var response: Boolean? = false
        if(
            hydrogen >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_atmosphere.hydrogen &&
            helium >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_atmosphere.helium &&
            carbon >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_atmosphere.carbon &&
            nitrogen >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_atmosphere.nitrogen &&
            argon >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_atmosphere.argon &&
            methane >= PlanetsAndStarsConfigs.atmosphere.generalAtmosphere.minimal_atmosphere.methane
        ) {
            response = true
        }
        return response!!
    }

    fun isRadioactive(): Boolean {
        return radioactive
    }
}