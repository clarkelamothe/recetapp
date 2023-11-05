package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class GetRecipeUseCase(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke() =
        flowOf(recipeRepository.getRemoteRecipes()).flowOn(Dispatchers.IO)
}