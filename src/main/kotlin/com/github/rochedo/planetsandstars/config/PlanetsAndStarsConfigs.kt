package com.github.rochedo.planetsandstars.config

import com.github.rochedo.planetsandstars.config.customplanets.Pollution
import com.github.rochedo.planetsandstars.config.formats.*
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File

// Based on https://github.com/GabrielOlvH/Industrial-Revolution/blob/893c64f2b50fc829555a49ed43ae4a906eeba552/src/main/kotlin/me/steven/indrev/config/IRConfig.kt

object PlanetsAndStarsConfigs {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    var machines: Machines
    var ores: Ores
    var planets: Planets
    var atmosphere: GeneralAtmosphere

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
    val alloySmelter: MachineConfig = MachineConfig(true, 1.0, 1.0)
    val crusher: MachineConfig = MachineConfig(true, 1.0, 1.0)
    val compressor: MachineConfig = MachineConfig(true, 1.0, 1.0)

    val rocketMk1: MachineConfig = MachineConfig(true, 0.0, 0.0)
    val rocketMk2: MachineConfig = MachineConfig(true, 0.0, 0.0)
    val rocketMk3: MachineConfig = MachineConfig(true, 0.0, 0.0)

    val rockAnalyzer: MachineConfig = MachineConfig(true, 1.0, 1.0)
}

class Ores {
    val tinOre: OreConfig = OreConfig(true, 7, 10)
    val leadOre: OreConfig = OreConfig(true, 5, 7)
    val silverOre: OreConfig = OreConfig(true, 5, 7)

    val deepslateTinOre: OreConfig = OreConfig(true, 3, 5)
    val deepslateLeadOre: OreConfig = OreConfig(true, 1, 3)
    val deepslateSilverOre: OreConfig = OreConfig(true, 1, 3)
}

class Planets {
    val mercury: PlanetConfig = PlanetConfig(true, true)
    val venus: PlanetConfig = PlanetConfig(true, true)
    val mars: PlanetConfig = PlanetConfig(true, true)
    val jupiter: PlanetConfig = PlanetConfig(true, true)
    val saturn: PlanetConfig = PlanetConfig(true, true)
    val uranus: PlanetConfig = PlanetConfig(true, true)
    val neptune: PlanetConfig = PlanetConfig(true, true)

    val moon: PlanetConfig = PlanetConfig(true, true)
}

class GeneralAtmosphere {
    val generalAtmosphere: AtmosphereConfig = AtmosphereConfig(15, Pollution(10, 10, 10,10, 10, 10))
    val spaceSuit: AtmosphereArmorConfig = AtmosphereArmorConfig(true)
}
