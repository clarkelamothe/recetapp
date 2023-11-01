package com.clarkelamothe.recetapp.recipe.presentation.model

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

sealed class RecipeUiState {
    object Loading : RecipeUiState()
    data class Success(val items: List<Recipe>) : RecipeUiState()
    data class Error(val msg: String) : RecipeUiState()
}
