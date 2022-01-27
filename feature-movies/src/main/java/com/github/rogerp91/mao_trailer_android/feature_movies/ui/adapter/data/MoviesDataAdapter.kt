package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.data

data class MoviesSectionDataAdapter(
    val titleSection: String,
    val moviesData: List<MoviesDataAdapter>
)
data class MoviesDataAdapter(
    val title: String,
    val backdropUrl: String,
    val posterUrl: String
)