package com.example.kotlinmultiplatformsandbox.data.repository

import com.example.kotlinmultiplatformsandbox.data.remote.RemoteDataSource
import com.example.kotlinmultiplatformsandbox.data.util.toMovie
import com.example.kotlinmultiplatformsandbox.domain.model.Movie
import com.example.kotlinmultiplatformsandbox.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) :MovieRepository{
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId).toMovie()
    }
}