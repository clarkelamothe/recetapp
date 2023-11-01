package com.clarkelamothe.recetapp.recipe.presentation

import androidx.lifecycle.viewModelScope
import com.clarkelamothe.recetapp.core.data.model.ApiResult
import com.clarkelamothe.recetapp.core.ui.BaseViewModel
import com.clarkelamothe.recetapp.recipe.domain.usecase.FilterOutRecipesUseCase
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiEvent
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiModel
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RecipeViewModel(
    val recipes: GetRecipeUseCase,
    val filterOutRecipesUseCase: FilterOutRecipesUseCase
) : BaseViewModel<RecipeUiEvent>() {
    private val _uiState = MutableStateFlow<RecipeUiState>(RecipeUiState.Loading)
    val uiState: StateFlow<RecipeUiState> = _uiState

    init {
        getData()
    }

    fun getData() {
        _uiState.value = RecipeUiState.Loading
        viewModelScope.launch {
            recipes()
                .catch { _uiState.value = RecipeUiState.Error("Oops! Something went wrong.") }
                .collect { apiResult ->
                    when (apiResult) {
                        is ApiResult.Error -> _uiState.value =
                            RecipeUiState.Error(apiResult.exception.message.toString())

                        is ApiResult.Success -> _uiState.value =
                            RecipeUiState.Success(apiResult.data.map {
                                it.toUiModel()
                            })
                    }
                }
        }
    }

    fun onRecipeClicked(recipe: RecipeUiModel) = sendEvent(RecipeUiEvent.OnItemClicked(recipe))

    fun search(query: String?) {
        val list = _uiState.value
        val result = filterOutRecipesUseCase(
            query,
            (list as RecipeUiState.Success).items.map { it.toDomain() })

        sendEvent(
            RecipeUiEvent.OnSearchQuery(result.map { it.toUiModel() })
        )
    }

    fun retryOnErrorClicked() {
        sendEvent(RecipeUiEvent.OnRetryWhenError)
    }
}