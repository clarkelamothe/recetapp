package com.clarkelamothe.recetapp.recipe.data

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import com.clarkelamothe.recetapp.core.data.model.ApiResult
import com.clarkelamothe.recetapp.core.data.model.RecipeResponse
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeDto
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeService
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Response

class RecipeRepositoryImpTest {

    private lateinit var recipeRepositoryImp: RecipeRepositoryImp
    private lateinit var recipeService: RecipeService

    @BeforeEach
    fun setup() {
        recipeService = mockk(relaxed = true)
        recipeRepositoryImp = RecipeRepositoryImp(recipeService)
    }

    @Test
    fun `get recipes while service throws exception and return api result error`() = runBlocking {
        val exception = Exception()
        coEvery { recipeService.getRemoteRecipes() } throws exception

        val result = recipeRepositoryImp.getRemoteRecipes()
        val expected = ApiResult.Error<List<Recipe>>(exception)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `get recipes while service is successful return api result success`(): Unit = runBlocking {
        coEvery { recipeService.getRemoteRecipes() } returns Response.success(null)

        val result = recipeRepositoryImp.getRemoteRecipes()

        assertThat(result).isInstanceOf<ApiResult.Success<List<Recipe>>>()
    }

    @Test
    fun `get recipes while service is successful return api result success with correct data`() =
        runBlocking {
            val list = (1..10).map { mockk<RecipeDto>(relaxed = true) }

            coEvery { recipeService.getRemoteRecipes() } returns Response.success(
                RecipeResponse(
                    list
                )
            )

            val result = recipeRepositoryImp.getRemoteRecipes()
            val expected = ApiResult.Success(list.map { Recipe() }).data

            assertThat((result as ApiResult.Success).data).isEqualTo(expected)
        }
}