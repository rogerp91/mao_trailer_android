package com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model

data class DiscoverPopularTopDTO(
    val topRated: List<MovieDTO>,
    val discover: List<MovieDTO>,
    val popular: List<MovieDTO>,
)
