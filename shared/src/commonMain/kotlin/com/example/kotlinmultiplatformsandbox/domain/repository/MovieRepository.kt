package com.example.kotlinmultiplatformsandbox.domain.repository

import com.example.kotlinmultiplatformsandbox.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}