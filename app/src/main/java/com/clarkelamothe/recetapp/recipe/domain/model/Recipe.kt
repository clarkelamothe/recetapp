package com.clarkelamothe.recetapp.recipe.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val imageUrl: String,
    val name: String
) : Parcelable