package com.clarkelamothe.recetapp.core.di.modules

import com.clarkelamothe.recetapp.recipe.data.RecipeRepositoryImp
import com.clarkelamothe.recetapp.recipe.domain.RecipeRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {
    factoryOf(::RecipeRepositoryImp) { bind<RecipeRepository>() }
}