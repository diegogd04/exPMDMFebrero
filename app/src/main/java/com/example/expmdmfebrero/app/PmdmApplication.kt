package com.example.expmdmfebrero.app

import android.app.Application
import com.example.expmdmfebrero.di.CollectionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class PmdmApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PmdmApplication)
            modules(
                CollectionModule().module
            )
        }
    }
}