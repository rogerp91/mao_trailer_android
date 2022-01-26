package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.di

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.TopRateInterpreter
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.utils.TopRateInterpreterDefault
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InterpreterModule {

    @Singleton
    @Provides
    fun providerTopRateInterpreter(): TopRateInterpreter {
        return TopRateInterpreterDefault()
    }
}
