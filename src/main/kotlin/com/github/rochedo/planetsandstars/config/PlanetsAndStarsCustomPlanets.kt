package com.github.rochedo.planetsandstars.config

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.fabricmc.loader.api.FabricLoader
import java.io.File

object PlanetsAndStarsCustomPlanets {
    private val read_gson = Gson()
    private val write_gson = GsonBuilder().setPrettyPrinting().create()

    private val folder: String = FabricLoader.getInstance().configDir.toString() + "/planetsandstars/customplanets"
    private val controller: CustomPlanetsController = read_gson.fromJson(folder + "controller.json", CustomPlanetsController::class.java)

    private var filename: String? = null
    fun defineCustomPlanetsValue() {
        for (file in controller.files) {
            filename = file
        }
    }
    var custom_planets: CustomPlanet  = read_gson.fromJson(folder + filename, CustomPlanet::class.java)

    fun verifyFolderExistence(): Boolean {
        var returns: Boolean = false
        try {
            if (!File(folder).exists()) {
                File(folder).mkdirs()
            }
            returns = true
        } catch (e: Exception) {
            println("Failed to create config, future crash os predicted")
        }
        return returns
    }
}