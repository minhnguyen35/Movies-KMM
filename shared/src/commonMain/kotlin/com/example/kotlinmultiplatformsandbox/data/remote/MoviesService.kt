package com.example.kotlinmultiplatformsandbox.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MoviesService: KtorApi() {
    suspend fun getMovies(page: Int = 1): MoviesResponse = client.get{
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}