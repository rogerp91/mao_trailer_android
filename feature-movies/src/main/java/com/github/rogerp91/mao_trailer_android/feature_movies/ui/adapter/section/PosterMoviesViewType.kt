package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.section

import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.data.MoviesSectionDataAdapter
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition.MoviesModelAdapter

class PosterMoviesViewType(
    private val data: MoviesSectionDataAdapter
) : MoviesModelAdapter {

    override fun getItemViewType(model: MoviesModelAdapter): Int {
        return if (model is PosterMoviesViewType) {
            1
        } else {
            model.getItemViewType(model)
        }
    }

    override fun getModelAdapterIfApply(model: MoviesModelAdapter): MoviesModelAdapter {
        return if (model is PosterMoviesViewType) {
            return this
        } else {
            model
        }
    }

    override fun getData(): MoviesSectionDataAdapter {
        return data
    }
}