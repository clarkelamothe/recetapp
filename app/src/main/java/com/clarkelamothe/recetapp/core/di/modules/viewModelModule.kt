package com.clarkelamothe.recetapp.core.di.modules

import com.clarkelamothe.recetapp.detail.presentation.viewmodel.DetailViewModel
import com.clarkelamothe.recetapp.recipe.presentation.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::RecipeViewModel)
    viewModelOf(::DetailViewModel)
}