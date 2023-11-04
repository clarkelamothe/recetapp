package com.clarkelamothe.recetapp.recipe.presentation.utils

import com.clarkelamothe.recetapp.recipe.domain.model.Location
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import com.clarkelamothe.recetapp.recipe.presentation.model.LocationUiModel
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiModel

fun Recipe.toUiModel() = with(this) {
    RecipeUiModel(
        imageUrl = imageUrl,
        name = name,
        description = description,
        location = LocationUiModel(longitude = location.longitude, latitude = location.latitude),
        items = items
    )
}

fun RecipeUiModel.toDomain() = with(this) {
    Recipe(
        imageUrl = imageUrl,
        name = name,
        description = description,
        location = Location(
            longitude = location.longitude,
            latitude = location.latitude
        ),
        items = items
    )
}