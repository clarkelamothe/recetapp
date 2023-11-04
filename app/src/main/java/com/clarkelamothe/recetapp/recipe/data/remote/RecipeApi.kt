package com.clarkelamothe.recetapp.recipe.data.remote

import com.clarkelamothe.recetapp.core.data.model.RecipeResponse
import com.clarkelamothe.recetapp.recipe.data.dto.RecipeDto
import retrofit2.Response
import retrofit2.http.GET

interface RecipeApi {
    //    @GET("https://demo2426464.mockable.io/recipes")
    @GET("https://run.mocky.io/v3/3c35f18a-8b82-4b23-bde1-eba3bdba3bf0")
    suspend fun getRecipes(): Response<RecipeResponse<List<RecipeDto>>>
}