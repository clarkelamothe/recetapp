package com.clarkelamothe.recetapp.recipe.domain.model

data class Recipe(
    val imageUrl: String = "",
    val name: String = "",
    val description: String = "",
    val location: Location = Location(),
    val items: List<String> = emptyList()
)