package com.clarkelamothe.recetapp.core.di.modules


import org.koin.dsl.module

val appModule = module {
    includes(
        viewModelModule,
        useCaseModule,
        serviceModule,
        repositoryModule
    )
}
