package com.github.rogerp91.mao_trailer_android.feature_movies.data

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.DiscoverPopularTopDTO
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.NetworkResult
import com.github.rogerp91.mao_trailer_android.feature_movies.data.source.MoviesDataSource
import com.github.rogerp91.mao_trailer_android.feature_movies.domain.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryDefault @Inject constructor(
    private val remoteDataSource: MoviesDataSource
) : MoviesRepository {

    override suspend fun getMovies(): NetworkResult<DiscoverPopularTopDTO> =
        remoteDataSource.getMovies()
}