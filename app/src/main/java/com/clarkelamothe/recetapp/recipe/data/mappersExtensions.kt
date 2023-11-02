package com.clarkelamothe.recetapp.recipe.data

import com.clarkelamothe.recetapp.recipe.data.remote.RecipeDto
import com.clarkelamothe.recetapp.recipe.domain.model.Location
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

fun RecipeDto.toDomain() = with(this) {
    Recipe(
        imageUrl = imageUrl,
        name = name,
        description = description,
        location = Location(
            location.longitude,
            location.latitude
        ),
        items = items
    )
}