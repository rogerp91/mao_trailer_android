package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.holder.*
import com.github.rogerp91.mao_trailer_android.feature_movies.databinding.MoviesBackdropListSectionBinding
import com.github.rogerp91.mao_trailer_android.feature_movies.databinding.MoviesPosterListSectionBinding

class MoviesViewHolderFactory(private val parent: ViewGroup) {

    fun getViewHolder(viewType: Int): MoviesViewHolder {
        return when (viewType) {
            0 -> BackdropMovieViewHolder(
                MoviesBackdropListSectionBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> {
                PosterMovieViewHolder(
                    MoviesPosterListSectionBinding.inflate(
                        LayoutInflater.from(
                            parent.context
                        ), parent, false
                    )
                )
            }
        }
    }
}