package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import kotlinx.coroutines.flow.flow

class GetRecipeUseCase(
    private val recipeRepository: RecipeRepository
) {

    suspend operator fun invoke() = flow {
        emit(
            recipeRepository.getRemoteRecipes()
        )
    }
}