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
    val hydrogen = Hydrogen
    val helium = Helium
    val carbon = CarbonDioxide
    val nitrogen = Nitrogen
    val oxygen = Oxygen
    val argon = Argon
    val methane = Methane
    val radioactive = Radioactive

    fun requireOxygenTank(): Boolean {
        var require: Boolean? = false
        if(oxygen >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_oxygen) {
            require = true
        }
        return require!!
    }

    fun isPolluted(): Boolean {
        var response: Boolean? = false
        if(
            hydrogen >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_atmosphere.hydrogen &&
            helium >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_atmosphere.helium &&
            carbon >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_atmosphere.carbon &&
            nitrogen >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_atmosphere.nitrogen &&
            argon >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_atmosphere.argon &&
            methane >= PlanetsAndStarsConfigs.atmosphere.general_atmosphere.minimal_atmosphere.methane
        ) {
            response = true
        }
        return response!!
    }

    fun isRadioactive(): Boolean {
        return radioactive
    }
}