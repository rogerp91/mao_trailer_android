package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.data.MoviesDataAdapter
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition.MoviesModelAdapter
import com.github.rogerp91.mao_trailer_android.feature_movies.databinding.MoviesItemPosterBinding
import com.github.rogerp91.mao_trailer_android.feature_movies.databinding.MoviesPosterListSectionBinding

class PosterMovieViewHolder(
    private val binding: MoviesPosterListSectionBinding
) : MoviesViewHolder(binding.root) {

    override fun bind(viewModel: MoviesModelAdapter) {
        val data = viewModel.getData()
        val adapter = PosterMoviesAdapter(viewModel.getData().moviesData)
        val context = binding.root.context

        binding.moviesTitlePoster.text = data.titleSection

        binding.moviesListPoster.apply {
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            setHasFixedSize(true)
            setLayoutManager(layoutManager)
            setAdapter(adapter)
        }
    }
}

private class PosterMoviesAdapter(
    private val moviesData: List<MoviesDataAdapter>
) : RecyclerView.Adapter<PosterMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PosterMoviesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemPosterBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PosterMoviesAdapter.ViewHolder, position: Int) {
        holder.bind(moviesData[position])
    }

    override fun getItemCount(): Int = moviesData.size

    inner class ViewHolder(
        private val binding: MoviesItemPosterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: MoviesDataAdapter) {
            with(binding) {
                moviesTitle.text = data.title
                moviesImage.load(data.posterUrl)
            }
        }
    }
}