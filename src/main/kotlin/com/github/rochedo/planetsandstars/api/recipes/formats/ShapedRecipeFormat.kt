package com.github.rochedo.planetsandstars.api.recipes.formats

import com.google.gson.JsonObject

class ShapedRecipeFormat (
    val type: String,
    val pattern: Array<String>,
    val key: JsonObject,
    val result: JsonObject
)