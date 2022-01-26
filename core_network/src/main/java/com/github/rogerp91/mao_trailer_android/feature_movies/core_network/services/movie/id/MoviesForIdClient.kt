package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.id

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.MovieDTO
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.MoviesService
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.BaseClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.NetworkResult
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.TopRateInterpreter
import javax.inject.Inject

interface MoviesForIdClient {

    suspend fun getForId(id: String): NetworkResult<List<MovieDTO>>
}

class MoviesForIdClientDefault @Inject constructor(
    private val services: MoviesService,
    private val interpreter: TopRateInterpreter
) : MoviesForIdClient, BaseClient() {

    override suspend fun getForId(id: String): NetworkResult<List<MovieDTO>> {
        var listMovie: List<MovieDTO> = emptyList()
        val result = safeApiCall { services.getTopRated() }
        if (result is NetworkResult.Success) {
            listMovie = interpreter.interpret(result.data)
        }
        return NetworkResult.Success(listMovie)
    }
}
