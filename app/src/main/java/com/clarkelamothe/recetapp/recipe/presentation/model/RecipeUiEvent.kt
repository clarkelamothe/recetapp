package com.clarkelamothe.recetapp.recipe.presentation.model

sealed class RecipeUiEvent {
    data class OnItemClicked(val recipe: RecipeUiModel) : RecipeUiEvent()
    data class OnSearchQuery(val searchResult: List<RecipeUiModel>) : RecipeUiEvent()
}