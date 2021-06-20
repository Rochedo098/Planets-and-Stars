package com.github.rochedo.planetsandstars.config

import com.github.rochedo.planetsandstars.config.customplanets.Atmosphere
import com.github.rochedo.planetsandstars.config.customplanets.CustomPlanet
import com.github.rochedo.planetsandstars.config.customplanets.Polution
import com.github.rochedo.planetsandstars.registry.PlanetsAndStarsBlocks
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File

// Based on https://github.com/GabrielOlvH/Industrial-Revolution/blob/893c64f2b50fc829555a49ed43ae4a906eeba552/src/main/kotlin/me/steven/indrev/config/IRConfig.kt

object PlanetsAndStarsCustomPlanets {
    private val gson = GsonBuilder().setPrettyPrinting().create()

    lateinit var basePlanet: BasePlanet

    private fun generateBase(file: String, write: Any) {
        val folder = File(FabricLoader.getInstance().configDir.toFile(), "planetsandstars/customplanets")
        if(!folder.exists()) {
            try {
                folder.mkdirs()
            } catch (e: Exception) {
                println("Custom planets is not loaded")
            }
        }
        val f = File(folder, file)
        if(!f.exists()) {
            f.createNewFile()
            f.writeText(gson.toJson(write))
        }
    }

    init {
        basePlanet = BasePlanet()

        generateBase("base_planet.json", basePlanet)
    }
}

class BasePlanet {
    val base_planet: CustomPlanet = CustomPlanet(false, "minecraft:cobblestone", arrayOf("null"), Atmosphere(true, 20, Polution(10, 10, 10, 10, 10, 10), true, "normal"))
}
