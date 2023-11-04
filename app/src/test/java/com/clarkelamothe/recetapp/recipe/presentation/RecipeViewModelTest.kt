package com.clarkelamothe.recetapp.recipe.presentation

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import com.clarkelamothe.recetapp.recipe.domain.usecase.FilterOutRecipesUseCase
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiEvent
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiModel
import com.clarkelamothe.recetapp.recipe.presentation.model.RecipeUiState
import com.clarkelamothe.recetapp.recipe.util.MainCoroutineExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MainCoroutineExtension::class)
class RecipeViewModelTest {

    private lateinit var viewModel: RecipeViewModel
    private lateinit var getRecipesUseCase: GetRecipeUseCase
    private lateinit var filterOutRecipesUseCase: FilterOutRecipesUseCase

    @BeforeEach
    fun setup() {
        getRecipesUseCase = mockk(relaxed = true)
        filterOutRecipesUseCase = mockk(relaxed = true)
        viewModel = RecipeViewModel(getRecipesUseCase, filterOutRecipesUseCase)

    }

    @Test
    fun `loading state when view model initializes`() = runTest {
        viewModel.uiState.test {
            assertThat(awaitItem()).isInstanceOf<RecipeUiState.Loading>()
        }
    }

    @Test
    fun `loading a state when setting it`() = runTest {
        viewModel.uiState.test {
            viewModel.setLoadingState()
            assertThat(awaitItem()).isInstanceOf<RecipeUiState.Loading>()
        }
    }

//    @Test
//    fun `get recipes success and update state correctly`() = runTest {
//        val success = flowOf(mockk<ApiResult.Error<List<Recipe>>>())
//
//        viewModel.uiState.test {
//            coEvery { getRecipesUseCase() } returns success
//            assertThat(awaitItem()).isInstanceOf<RecipeUiState.Loading>()
//            viewModel.getData()
//            assertThat((awaitItem())).isInstanceOf<RecipeUiState.Success>()
//        }
//    }


    @Test
    fun `on recipe clicked updates ui events correctly`() = runTest {
        val recipe = RecipeUiModel()
        val expected = RecipeUiEvent.OnItemClicked(RecipeUiModel())

        viewModel.eventFlow.test {
            viewModel.onRecipeClicked(recipe)
            assertThat(awaitItem()).isEqualTo(expected)
        }
    }

    @Test
    fun `retry `() = runTest {
        val expected = RecipeUiEvent.OnRetryWhenError
        viewModel.eventFlow.test {
            viewModel.retryOnErrorClicked()
            assertThat(awaitItem()).isEqualTo(expected)
        }
    }
}