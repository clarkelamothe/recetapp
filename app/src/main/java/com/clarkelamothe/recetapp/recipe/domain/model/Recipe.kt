package com.clarkelamothe.recetapp.recipe.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val imageUrl: String = "",
    val name: String = "",
    val description: String = "",
    val location: String = "",
    val items: List<String> = emptyList()
) : Parcelable