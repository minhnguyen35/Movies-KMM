package com.example.kotlinmultiplatformsandbox.android

import android.app.Application
import com.example.kotlinmultiplatformsandbox.android.di.appModule
import com.example.kotlinmultiplatformsandbox.di.getSharedModule
import org.koin.core.context.startKoin

class MovieApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModule())
        }
    }
}