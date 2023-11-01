package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import kotlinx.coroutines.flow.flowOf

class GetRecipeUseCase(
    private val recipeRepository: RecipeRepository
) {
    suspend operator fun invoke() = flowOf(recipeRepository.getRemoteRecipes())
}