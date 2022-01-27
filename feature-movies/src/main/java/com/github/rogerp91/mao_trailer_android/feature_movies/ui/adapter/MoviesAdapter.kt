package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition.MoviesModelAdapter
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.holder.MoviesViewHolder

class MoviesAdapter(
    private val moviesViewModel: List<MoviesModelAdapter>
) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolderFactory(parent).getViewHolder(viewType)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesViewModel[position])
    }

    override fun getItemCount(): Int = moviesViewModel.size

    override fun getItemViewType(position: Int): Int {
        val moviesViewModel = moviesViewModel[position]
        return moviesViewModel.getItemViewType(moviesViewModel)
    }
}
