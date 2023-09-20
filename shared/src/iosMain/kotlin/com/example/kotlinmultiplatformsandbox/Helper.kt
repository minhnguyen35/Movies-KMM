package com.example.kotlinmultiplatformsandbox

import com.example.kotlinmultiplatformsandbox.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class GreetingHelper: KoinComponent {
    private val greeting: Greeting by inject()
    fun greet(): String = greeting.greet()
}

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}