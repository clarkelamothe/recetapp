package com.clarkelamothe.recetapp.recipe.presentation

import androidx.lifecycle.viewModelScope
import com.clarkelamothe.recetapp.core.ui.BaseViewModel
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    val recipes: GetRecipeUseCase
) : BaseViewModel<RecipeUiEvent>() {
    private val _uiState = MutableStateFlow<RecipeUiState>(RecipeUiState.Loading)
    val uiState: StateFlow<RecipeUiState> = _uiState

    init {
        viewModelScope.launch {
            recipes().collect {
                _uiState.value = RecipeUiState.Success(it)
            }
        }
    }

    fun onRecipeClicked(recipe: Recipe) = sendEvent(RecipeUiEvent.OnItemClicked(recipe))

    fun search(query: String?) {
        val list = _uiState.value
        val result = (list as RecipeUiState.Success).items.filter {
            it.name.lowercase().contains(query?.lowercase() ?: "")
        }
        sendEvent(
            RecipeUiEvent.OnSearchQuery(result)
        )
    }
}

sealed class RecipeUiEvent {
    data class OnItemClicked(val recipe: Recipe) : RecipeUiEvent()
    data class OnSearchQuery(val searchResult: List<Recipe>) : RecipeUiEvent()
}

sealed class RecipeUiState {
    object Loading : RecipeUiState()
    data class Success(val items: List<Recipe>) : RecipeUiState()
    data class Error(val msg: String) : RecipeUiState()
}