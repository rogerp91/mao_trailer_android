package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition

import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.data.MoviesSectionDataAdapter

interface MoviesModelAdapter {

    fun getItemViewType(model: MoviesModelAdapter): Int

    fun getModelAdapterIfApply(model: MoviesModelAdapter): MoviesModelAdapter

    fun getData(): MoviesSectionDataAdapter
}