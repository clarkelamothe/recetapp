package com.clarkelamothe.recetapp.recipe.data

import com.clarkelamothe.recetapp.core.data.model.ApiResult
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeService
import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

class RecipeRepositoryImp(
    private val recipeService: RecipeService
) : RecipeRepository {
    override suspend fun getRemoteRecipes(): ApiResult<List<Recipe>> {
        return try {
            val recipes = recipeService.getRemoteRecipes()

            ApiResult.Success(
                recipes.body()?.data?.map {
                    it.toDomain()
                } ?: emptyList()
            )
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
    }
}