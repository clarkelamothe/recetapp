package com.clarkelamothe.recetapp.recipe.data

import com.clarkelamothe.recetapp.recipe.data.remote.LocationDto
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeDto
import com.clarkelamothe.recetapp.recipe.domain.model.Location
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

fun RecipeDto.toDomain() = with(this) {
    Recipe(
        imageUrl = imageUrl,
        name = name,
        description = description,
        location = location.toDomain(),
        items = items
    )
}

fun LocationDto.toDomain() = with(this) {
    Location(
        longitude = longitude, latitude = latitude
    )
}