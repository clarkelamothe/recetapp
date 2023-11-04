package com.clarkelamothe.recetapp.core.di.modules

import com.clarkelamothe.recetapp.recipe.domain.usecase.FilterOutRecipesUseCase
import com.clarkelamothe.recetapp.recipe.domain.usecase.GetRecipeUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetRecipeUseCase)
    factoryOf(::FilterOutRecipesUseCase)
}