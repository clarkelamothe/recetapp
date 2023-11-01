package com.clarkelamothe.recetapp.recipe.domain

import com.clarkelamothe.recetapp.core.data.model.ApiResult
import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRemoteRecipes(): ApiResult<List<Recipe>>
}