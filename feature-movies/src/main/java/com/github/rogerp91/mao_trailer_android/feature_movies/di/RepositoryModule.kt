package com.github.rogerp91.mao_trailer_android.feature_movies.di

import com.github.rogerp91.mao_trailer_android.feature_movies.data.MoviesRepositoryDefault
import com.github.rogerp91.mao_trailer_android.feature_movies.data.source.MoviesDataSource
import com.github.rogerp91.mao_trailer_android.feature_movies.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun getProviderRepositoryRemote(remoteDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepositoryDefault(remoteDataSource)
    }
}