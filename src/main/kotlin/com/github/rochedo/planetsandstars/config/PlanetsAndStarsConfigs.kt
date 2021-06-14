package com.github.rochedo.planetsandstars.config

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File
import java.lang.Exception

object PlanetsAndStarsConfigs {
    private val read_gson = Gson()
    private val write_gson = GsonBuilder().setPrettyPrinting().create()
    private val folder: String = FabricLoader.getInstance().configDir.toString() + "/planetsandstars/"

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

            returns = true
        } catch(e: Exception) {
            println("Failed to create config, future crash os predicted")
        }
        return returns
    }

    fun writeOreConfig() {
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

    fun writeMachinesConfig() {
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
}