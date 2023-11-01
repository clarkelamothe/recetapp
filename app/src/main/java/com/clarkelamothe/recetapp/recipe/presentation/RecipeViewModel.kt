package com.clarkelamothe.recetapp.recipe.presentation

import androidx.lifecycle.viewModelScope
import com.clarkelamothe.recetapp.core.data.model.ApiResult
import com.clarkelamothe.recetapp.core.ui.BaseViewModel
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiEvent
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RecipeViewModel(
    val recipes: GetRecipeUseCase
) : BaseViewModel<RecipeUiEvent>() {
    private val _uiState = MutableStateFlow<RecipeUiState>(RecipeUiState.Loading)
    val uiState: StateFlow<RecipeUiState> = _uiState

    init {
        viewModelScope.launch {
            recipes()
                .catch { _uiState.value = RecipeUiState.Error("Oops! Something went wrong.") }
                .collect {
                    when (it) {
                        is ApiResult.Error -> _uiState.value =
                            RecipeUiState.Error(it.exception.message.toString())

                        is ApiResult.Success<*> -> _uiState.value =
                            RecipeUiState.Success(it.data as List<Recipe>)
                    }
                }
        }
    }

    fun onRecipeClicked(recipe: Recipe) = sendEvent(RecipeUiEvent.OnItemClicked(recipe))

    fun search(query: String?) {
        val list = _uiState.value
        val result = (list as RecipeUiState.Success).items.filter {
            it.name.lowercase().contains(query?.lowercase()?.trim() ?: "")
        }
        sendEvent(
            RecipeUiEvent.OnSearchQuery(result)
        )
    }
}