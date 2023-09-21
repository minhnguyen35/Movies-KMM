package com.example.kotlinmultiplatformsandbox.android.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinmultiplatformsandbox.domain.model.Movie
import com.example.kotlinmultiplatformsandbox.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    val getMovieUseCase: GetMovieUseCase,
    val movieId: Int
) : ViewModel(){
    var uiState by mutableStateOf(DetailScreenState())

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            uiState = try {
                val movie = getMovieUseCase(movieId = movieId)
                uiState.copy(loading = false, movie = movie)
            }catch (error: Throwable) {
                uiState.copy(

                )
            }
        }
    }
}

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)