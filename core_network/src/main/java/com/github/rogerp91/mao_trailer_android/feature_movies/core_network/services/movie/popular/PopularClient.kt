package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.popular

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.MovieDTO
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.MoviesService
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.BaseClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.NetworkResult
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.TopRateInterpreter
import javax.inject.Inject

interface PopularClient {

    suspend fun getPopular(): NetworkResult<List<MovieDTO>>
}

class PopularClientDefault @Inject constructor(
    private val services: MoviesService,
    private val interpreter: TopRateInterpreter
) : PopularClient, BaseClient() {

    override suspend fun getPopular(): NetworkResult<List<MovieDTO>> {
        var listMovie: List<MovieDTO> = emptyList()
        val result = safeApiCall { services.getTopRated() }

        if (result is NetworkResult.Success) {
            listMovie = interpreter.interpret(result.data)
        }
        return NetworkResult.Success(listMovie)
    }
}
