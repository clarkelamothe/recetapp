package com.clarkelamothe.recetapp.recipe.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeUiModel(
    val imageUrl: String = "",
    val name: String = "",
    val description: String = "",
    val location: LocationUiModel = LocationUiModel(),
    val items: List<String> = emptyList()
) : Parcelable

@Parcelize
data class LocationUiModel(
    val longitude: Double = 0.0,
    val latitude: Double = 0.0
) : Parcelable