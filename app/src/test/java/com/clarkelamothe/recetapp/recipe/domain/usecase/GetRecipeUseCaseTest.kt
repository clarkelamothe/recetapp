package com.clarkelamothe.recetapp.recipe.domain.usecase

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.clarkelamothe.recetapp.core.data.model.ApiResult
import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetRecipeUseCaseTest {
    private lateinit var getRecipeUseCase: GetRecipeUseCase
    private lateinit var recipeRepositoryImp: RecipeRepository

    @BeforeEach
    fun setup() {
        recipeRepositoryImp = mockk(relaxed = true)
        getRecipeUseCase = GetRecipeUseCase(recipeRepositoryImp)
    }

    @Test
    fun `get recipes use case returns ApiResult Success`() = runBlocking {
        val list = (1..10).map { Recipe() }
        val expected = ApiResult.Success(list)
        coEvery { recipeRepositoryImp.getRemoteRecipes() } returns ApiResult.Success(list)

        getRecipeUseCase().test {
            assertThat(awaitItem()).isEqualTo(expected)
            awaitComplete()
        }
    }

    @Test
    fun `get recipes use case returns ApiResult Error`() = runBlocking {
        val expected = "test error msg"
        coEvery { recipeRepositoryImp.getRemoteRecipes() } returns ApiResult.Error(
            Exception(
                expected
            )
        )

        getRecipeUseCase().test {

            assertThat((awaitItem() as ApiResult.Error).exception.message).isEqualTo(expected)
            awaitComplete()
        }
    }
}