package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model

import com.github.rogerp91.wombatmovierestclient.client.model.ResultDTO

data class DataDTO(
    val page: Int,
    val results: List<ResultDTO>,
    val totalPages: Int,
    val totalResults: Int
)
