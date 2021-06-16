package com.github.rochedo.planetsandstars.config

import com.github.rochedo.planetsandstars.api.atmosphere.Contaminated
import com.github.rochedo.planetsandstars.config.custominput.PolutionConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File

object PlanetsAndStarsConfigs {
    private val read_gson = Gson()
    private val write_gson = GsonBuilder().setPrettyPrinting().create()
    private val folder: String = FabricLoader.getInstance().configDir.toString() + "/planetsandstars/"

    val oresConfig = read_gson.fromJson(folder + "ores.json", OresConfig::class.java)
    val machinesConfig = read_gson.fromJson(folder + "machines.json", MachinesConfig::class.java)
    val atmosphereConfig = read_gson.fromJson(folder + "atmosphere.json", AtmosphereConfig::class.java)

    fun verifyConfigExists(): Boolean {
        var returns: Boolean = false
        try {
            val oreConfigFile: File = File(folder + "ores.json")
            if (!oreConfigFile.exists()) {
                writeOreConfig()
            }

            val machinesConfigFile: File = File(folder + "machines.json")
            if (!machinesConfigFile.exists()) {
                writeMachinesConfig()
            }

            val atmosphereConfigFile: File = File(folder + "atmosphere.json")
            if (!atmosphereConfigFile.exists()) {
                writeAtmosphereConfig()
            }

            returns = true
        } catch(e: Exception) {
            println("Failed to create config, future crash os predicted")
        }
        return returns
    }

    private fun writeOreConfig() {
        val config = OresConfig(
            tin_ore = true,
            lead_ore = true,
            silver_ore = true,

            tin_ore_rarity = 1,
            lead_ore_rarity = 2,
            silver_ore_rarity = 3
        )
        val writeConfig = write_gson.toJson(config)
        val file: File = File(folder + "ores.json")
        file.writeText(writeConfig)
    }

    private fun writeMachinesConfig() {
        val config = MachinesConfig (
            alloy_smelter_active = true,
            alloy_smelter_speed_modifier = 1,
            alloy_smelter_consume_modifier = 1,

            crusher_active = true,
            crusher_speed_modifier = 1,
            crusher_consume_modifier = 1
        )
        val writeconfig = write_gson.toJson(config)
        val file: File = File(folder + "machines.json")
        file.writeText(writeconfig)
    }

    private fun writeAtmosphereConfig() {
        val config = AtmosphereConfig(
            oxygen_reqired = 22,
            polution = arrayOf(PolutionConfig(
                hydrogen = 25,
                helium = 25,
                carbon = 25,
                nitrogen = 78,
                argon = 25,
                methane = 2
            )),
            radioactive = true,
            contaminated = Contaminated.normal
        )
        val writeConfig = write_gson.toJson(config)
        val file: File = File(folder + "atmosphere.json")
        file.writeText(writeConfig)
    }
}