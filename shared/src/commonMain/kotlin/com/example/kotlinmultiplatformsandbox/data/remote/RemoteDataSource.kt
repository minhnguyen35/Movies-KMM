package com.example.kotlinmultiplatformsandbox.data.remote

import com.example.kotlinmultiplatformsandbox.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource (
    private val apiService: MoviesService,
    private val dispatcher: Dispatcher
){
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId)
    }
}