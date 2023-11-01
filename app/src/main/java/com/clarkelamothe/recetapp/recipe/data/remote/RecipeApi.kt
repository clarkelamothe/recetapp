package com.clarkelamothe.recetapp.recipe.data.remote

import com.clarkelamothe.recetapp.core.data.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET

interface RecipeApi {
    @GET("https://run.mocky.io/v3/e701f374-3806-42a0-b267-7ba7ef550983")
    suspend fun getRecipes(): Response<RecipeResponse<List<RecipeDto>>>
}