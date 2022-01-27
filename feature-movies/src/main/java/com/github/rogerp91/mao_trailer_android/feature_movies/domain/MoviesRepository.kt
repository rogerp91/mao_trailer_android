package com.github.rogerp91.mao_trailer_android.feature_movies.domain

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.DiscoverPopularTopDTO
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.NetworkResult

interface MoviesRepository {

    suspend fun getMovies(): NetworkResult<DiscoverPopularTopDTO>
}