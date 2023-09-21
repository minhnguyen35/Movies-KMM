package com.example.kotlinmultiplatformsandbox.android.di

import com.example.kotlinmultiplatformsandbox.android.detail.DetailViewModel
import com.example.kotlinmultiplatformsandbox.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get())
    }
}