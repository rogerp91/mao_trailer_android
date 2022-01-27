package com.github.rogerp91.mao_trailer_android.feature_movies.data.source

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.DiscoverPopularTopDTO
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.multiple.DiscoverPopularTopClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.NetworkResult
import com.github.rogerp91.mao_trailer_android.feature_movies.domain.MoviesRepository
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val client: DiscoverPopularTopClient
) : MoviesDataSource {

    override suspend fun getMovies(): NetworkResult<DiscoverPopularTopDTO> {
        return client.getDiscoverPopularTop()
    }
}