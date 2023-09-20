package com.example.kotlinmultiplatformsandbox.di

import com.example.kotlinmultiplatformsandbox.data.remote.MoviesService
import com.example.kotlinmultiplatformsandbox.data.remote.RemoteDataSource
import com.example.kotlinmultiplatformsandbox.data.repository.MovieRepositoryImpl
import com.example.kotlinmultiplatformsandbox.domain.repository.MovieRepository
import com.example.kotlinmultiplatformsandbox.domain.usecase.GetMovieUseCase
import com.example.kotlinmultiplatformsandbox.domain.usecase.GetMoviesUseCase
import com.example.kotlinmultiplatformsandbox.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory {
        RemoteDataSource(get(), get())
    }
    factory {
        MoviesService()
    }
}

private val utilityModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
    factory {
        GetMovieUseCase()
    }
    factory {
        GetMoviesUseCase()
    }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModule() = sharedModules