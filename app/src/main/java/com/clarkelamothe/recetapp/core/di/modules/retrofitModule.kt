package com.clarkelamothe.recetapp.core.di.modules

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single(named(Qualifier.BASE_URL)) { "https://run.mocky.io/v3/" }

    single {
        Retrofit.Builder().baseUrl(get<String>(named(Qualifier.BASE_URL))).client(get())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BASIC
                )
            ).build()
    }
}

enum class Qualifier {
    BASE_URL
}