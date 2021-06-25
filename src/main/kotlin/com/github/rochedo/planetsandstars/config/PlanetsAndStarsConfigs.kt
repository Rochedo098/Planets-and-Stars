package com.github.rochedo.planetsandstars.config

import com.github.rochedo.planetsandstars.config.customplanets.Polution
import com.github.rochedo.planetsandstars.config.formats.*
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File

// Based on https://github.com/GabrielOlvH/Industrial-Revolution/blob/893c64f2b50fc829555a49ed43ae4a906eeba552/src/main/kotlin/me/steven/indrev/config/IRConfig.kt

object PlanetsAndStarsConfigs {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    lateinit var machines: Machines
    lateinit var ores: Ores
    lateinit var planets: Planets
    lateinit var atmosphere: GeneralAtmosphere

    private fun generateConfigs(file: String, write: Any) {
        val folder = File(FabricLoader.getInstance().configDir.toFile(), "planetsandstars")
        if(!folder.exists()) {
            try {
                folder.mkdirs()
            } catch (e: Exception) {
                println("Could not create configs, future crash is possible")
            }
        }
        val fi = File(folder, file)
        if (!fi.exists()) {
            fi.createNewFile()
            fi.writeText(gson.toJson(write))
        }
    }

    init {
        machines = Machines()
        ores = Ores()
        planets = Planets()
        atmosphere = GeneralAtmosphere()

        generateConfigs("machines.json", machines)
        generateConfigs("ores.json", ores)
        generateConfigs("planets.json", planets)
        generateConfigs("atmosphere.json", atmosphere)
    }
}

class Machines {
    val alloy_smelter: MachineConfig = MachineConfig(false, 1.0, 1.0)
    val crusher: MachineConfig = MachineConfig(false, 1.0, 1.0)
    val compressor: MachineConfig = MachineConfig(false, 1.0, 1.0)

    val rocket_mk1: MachineConfig = MachineConfig(true, 0.0, 0.0)
    val rocket_mk2: MachineConfig = MachineConfig(true, 0.0, 0.0)
    val rocket_mk3: MachineConfig = MachineConfig(true, 0.0, 0.0)

    val rock_analyzer: MachineConfig = MachineConfig(true, 1.0, 1.0)
}

class Ores {
    val tin_ore: OreConfig = OreConfig(true, 7, 10)
    val lead_ore: OreConfig = OreConfig(true, 5, 7)
    val silver_ore: OreConfig = OreConfig(true, 5, 7)

    val deepslate_tin_ore: OreConfig = OreConfig(true, 3, 5)
    val deepslate_lead_ore: OreConfig = OreConfig(true, 1, 3)
    val deepslate_silver_ore: OreConfig = OreConfig(true, 1, 3)
}

class Planets {
    val mercury: PlanetConfig = PlanetConfig(false, true)
    val venus: PlanetConfig = PlanetConfig(false, true)
    val mars: PlanetConfig = PlanetConfig(false, true)
    val jupiter: PlanetConfig = PlanetConfig(false, true)
    val saturn: PlanetConfig = PlanetConfig(false, true)
    val uranus: PlanetConfig = PlanetConfig(false, true)
    val neptune: PlanetConfig = PlanetConfig(false, true)
}

class GeneralAtmosphere {
    val general_atmosphere: AtmosphereConfig = AtmosphereConfig(15, Polution(10, 10, 10,10, 10, 10))
    val thermal_suit: AtmosphereArmorConfig = AtmosphereArmorConfig(true)
    val space_suit: AtmosphereArmorConfig = AtmosphereArmorConfig(true)
}
