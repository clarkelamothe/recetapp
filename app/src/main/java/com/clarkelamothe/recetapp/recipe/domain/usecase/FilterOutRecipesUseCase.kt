package com.clarkelamothe.recetapp.recipe.domain.usecase

import com.clarkelamothe.recetapp.recipe.domain.model.Recipe

class FilterOutRecipesUseCase {
    operator fun invoke(query: String?, recipes: List<Recipe>) = recipes.filter {
        it.name.contains(query?.trim().toString(), true) ||
                it.items.contains(query?.lowercase()?.trim().toString())
    }
}