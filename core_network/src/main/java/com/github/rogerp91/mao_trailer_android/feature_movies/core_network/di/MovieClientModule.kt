package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.di

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.MoviesService
import com.github.rogerp91.wombatmovierestclient.client.services.movie.discover.DiscoverClient
import com.github.rogerp91.wombatmovierestclient.client.services.movie.discover.DiscoverClientDefault
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.id.MoviesForIdClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.id.MoviesForIdClientDefault
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.multiple.DiscoverPopularTopClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.multiple.DiscoverPopularTopDefault
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.popular.PopularClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.popular.PopularClientDefault
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.top_rated.MovieTopRatedClient
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.top_rated.MovieTopRatedClientDefault
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.TopRateInterpreter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieClientModule {

    @Singleton
    @Provides
    fun provideMovieTopRatedClient(
        services: MoviesService,
        interpreter: TopRateInterpreter
    ): MovieTopRatedClient {
        return MovieTopRatedClientDefault(services, interpreter)
    }

    @Singleton
    @Provides
    fun provideMovieDiscoverClient(
        services: MoviesService,
        interpreter: TopRateInterpreter
    ): DiscoverClient {
        return DiscoverClientDefault(services, interpreter)
    }

    @Singleton
    @Provides
    fun provideMoviePopularClient(
        services: MoviesService,
        interpreter: TopRateInterpreter
    ): PopularClient {
        return PopularClientDefault(services, interpreter)
    }

    @Singleton
    @Provides
    fun provideMovieForIdClient(
        services: MoviesService,
        interpreter: TopRateInterpreter
    ): MoviesForIdClient {
        return MoviesForIdClientDefault(services, interpreter)
    }

    @Singleton
    @Provides
    fun provideDiscoverPopularTopClient(
        services: MoviesService,
        interpreter: TopRateInterpreter
    ): DiscoverPopularTopClient {
        return DiscoverPopularTopDefault(services, interpreter)
    }
}
