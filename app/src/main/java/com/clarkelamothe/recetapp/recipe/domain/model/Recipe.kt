package com.clarkelamothe.recetapp.recipe.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val imageUrl: String = "",
    val name: String = "",
    val description: String = "",
    val location: Location = Location(),
    val items: List<String> = emptyList()
) : Parcelable

@Parcelize
data class Location(
    val longitude: Float = 0f,
    val latitude: Float = 0f
) : Parcelable