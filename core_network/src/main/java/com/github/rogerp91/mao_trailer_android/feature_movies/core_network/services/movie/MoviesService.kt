package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.services.movie

import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.DataDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("movie/top_rated")
    suspend fun getTopRated(): Response<DataDTO>

    @GET("discover/movie")
    suspend fun getDiscover(): Response<DataDTO>

    @GET("movie/popular")
    suspend fun getPopular(): Response<DataDTO>

    @GET("movie/{id}")
    suspend fun getMoviesForId(@Path("id") id: String): Response<DataDTO>
}
