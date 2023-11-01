package com.clarkelamothe.recetapp.recipe.presentation.model

sealed class RecipeUiState {
    object Loading : RecipeUiState()
    data class Success(val items: List<RecipeUiModel>) : RecipeUiState()
    data class Error(val msg: String) : RecipeUiState()
}
