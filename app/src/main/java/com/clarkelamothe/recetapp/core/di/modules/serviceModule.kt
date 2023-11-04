package com.clarkelamothe.recetapp.core.di.modules

import com.clarkelamothe.recetapp.recipe.data.remote.RecipeApi
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    factory {
        RecipeService(
            get<Retrofit>().create(RecipeApi::class.java)
        )
    }
}