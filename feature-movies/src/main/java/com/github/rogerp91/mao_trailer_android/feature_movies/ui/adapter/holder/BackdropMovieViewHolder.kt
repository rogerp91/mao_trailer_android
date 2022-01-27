package com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.data.MoviesDataAdapter
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition.MoviesModelAdapter
import com.github.rogerp91.mao_trailer_android.feature_movies.databinding.MoviesBackdropListSectionBinding
import com.github.rogerp91.mao_trailer_android.feature_movies.databinding.MoviesItemBackdropBinding

class BackdropMovieViewHolder(
    private val binding: MoviesBackdropListSectionBinding
) : MoviesViewHolder(binding.root) {

    override fun bind(viewModel: MoviesModelAdapter) {
        val data = viewModel.getData()
        val adapter = BackdropMoviesAdapter(viewModel.getData().moviesData)
        val context = binding.root.context

        binding.moviesTitleBackdrop.text = data.titleSection

        binding.moviesListBackdrop.apply {
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            setHasFixedSize(true)
            setLayoutManager(layoutManager)
            setAdapter(adapter)
        }
    }
}

private class BackdropMoviesAdapter(
    private val moviesData: List<MoviesDataAdapter>
) : RecyclerView.Adapter<BackdropMoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BackdropMoviesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemBackdropBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BackdropMoviesAdapter.ViewHolder, position: Int) {
        holder.bind(moviesData[position])
    }

    override fun getItemCount(): Int = moviesData.size

    inner class ViewHolder(
        private val binding: MoviesItemBackdropBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: MoviesDataAdapter) {
            with(binding) {
                moviesTitle.text = data.title
                moviesImage.load(data.backdropUrl)
            }
        }
    }
}