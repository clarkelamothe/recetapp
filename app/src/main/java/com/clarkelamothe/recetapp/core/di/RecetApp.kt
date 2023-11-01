package com.clarkelamothe.recetapp.core.di

import android.app.Application
import com.clarkelamothe.recetapp.core.di.modules.appModule
import com.clarkelamothe.recetapp.core.di.modules.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RecetApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RecetApp)

            modules(
                appModule,
                retrofitModule
            )
        }
    }
}