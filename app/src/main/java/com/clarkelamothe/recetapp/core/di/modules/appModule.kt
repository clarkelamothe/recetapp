package com.clarkelamothe.recetapp.core.di.modules

import com.clarkelamothe.recetapp.detail.presentation.DetailViewModel
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import com.clarkelamothe.recetapp.recipe.presentation.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::RecipeViewModel)
    viewModelOf(::DetailViewModel)
    factoryOf(::GetRecipeUseCase)
}