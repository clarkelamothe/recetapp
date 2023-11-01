package com.clarkelamothe.recetapp.recipe.data.remote

class RecipeService(
    private val recipeApi: RecipeApi
) {

    suspend fun getRemoteRecipes() = recipeApi.getRecipes()
}