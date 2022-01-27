package com.github.rogerp91.mao_trailer_android.feature_movies.di

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.multiple.DiscoverPopularTopClient
import com.github.rogerp91.mao_trailer_android.feature_movies.data.source.MoviesDataSource
import com.github.rogerp91.mao_trailer_android.feature_movies.data.source.MoviesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun getProviderMoviesRemoteDataSource(client: DiscoverPopularTopClient): MoviesDataSource {
        return MoviesRemoteDataSource(client)
    }
}