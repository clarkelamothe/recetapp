package com.clarkelamothe.recetapp.recipe.data.dto

data class RecipeDto(
    val imageUrl: String,
    val name: String,
    val description: String,
    val location: LocationDto,
    val items: List<String>
)