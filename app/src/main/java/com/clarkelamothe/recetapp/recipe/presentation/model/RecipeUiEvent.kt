package com.clarkelamothe.recetapp.recipe.presentation.model

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

sealed class RecipeUiEvent {
    data class OnItemClicked(val recipe: Recipe) : RecipeUiEvent()
    data class OnSearchQuery(val searchResult: List<Recipe>) : RecipeUiEvent()
}
