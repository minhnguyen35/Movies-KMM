package com.example.kotlinmultiplatformsandbox.util

import com.example.kotlinmultiplatformsandbox.di.getSharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(){
    startKoin {
        module { getSharedModule() }
    }
}