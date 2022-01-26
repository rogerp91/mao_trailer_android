package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.di

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.Constants.BASE_URL
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.interceptor.QueryParametersInterceptor
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)

        okHttpClient.apply {
            addInterceptor(QueryParametersInterceptor())
        }
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)
}
