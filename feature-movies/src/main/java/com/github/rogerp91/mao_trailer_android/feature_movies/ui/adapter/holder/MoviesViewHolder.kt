package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition.MoviesModelAdapter

abstract class MoviesViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(viewModel: MoviesModelAdapter)
}