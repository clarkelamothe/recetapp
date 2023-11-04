package com.clarkelamothe.recetapp.core.di.modules

import com.clarkelamothe.recetapp.detail.presentation.DetailViewModel
import com.clarkelamothe.recetapp.recipe.data.RecipeRepositoryImp
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeApi
import com.clarkelamothe.recetapp.recipe.data.remote.RecipeService
import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import com.clarkelamothe.recetapp.recipe.domain.usecase.FilterOutRecipesUseCase
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import com.clarkelamothe.recetapp.recipe.presentation.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    viewModelOf(::RecipeViewModel)
    viewModelOf(::DetailViewModel)
    factoryOf(::GetRecipeUseCase)
    factoryOf(::FilterOutRecipesUseCase)
    factory {
        RecipeService(
            get<Retrofit>().create(RecipeApi::class.java)
        )
    }

    factoryOf(::RecipeRepositoryImp) { bind<RecipeRepository>() }
}