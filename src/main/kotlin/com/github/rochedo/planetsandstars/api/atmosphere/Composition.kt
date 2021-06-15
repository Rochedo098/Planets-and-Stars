package com.github.rochedo.planetsandstars.api.atmosphere

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
        if(oxygen >= PlanetsAndStarsConfigs.atmosphereConfig.oxygen_reqired) {
            require = true
        }
        return require!!
    }

    fun isPolluted(): Boolean {
        var response: Boolean? = false
        if(hydrogen >= 25 && helium >= 25 && carbon >= 25 && nitrogen >= 78 && argon >= 25 && methane >= 2) {
            response = true
        }
        return response!!
    }

    fun isRadioactive(): Boolean {
        return radioactive
    }
}