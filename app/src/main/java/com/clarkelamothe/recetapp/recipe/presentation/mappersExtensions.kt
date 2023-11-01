package com.clarkelamothe.recetapp.recipe.presentation

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import com.clarkelamothe.recetapp.recipe.presentation.model.LocationUiModel
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiModel

fun Recipe.toUiModel() = with(this) {
    RecipeUiModel(
        imageUrl = imageUrl,
        name = name,
        description = description,
        location = LocationUiModel(longitude = location.longitude, latitude = location.longitude),
        items = items
    )
}