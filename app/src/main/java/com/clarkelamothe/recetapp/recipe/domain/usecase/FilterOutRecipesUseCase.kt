package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

class FilterOutRecipesUseCase {
    operator fun invoke(query: String?, recipes: List<Recipe>) = recipes.filter {
        it.name.lowercase().contains(query?.lowercase()?.trim() ?: "")
    }
}