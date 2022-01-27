package com.github.rogerp91.mao_trailer_android.feature_movies.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.rogerp91.mao_trailer_android.feature_movies.core_network.model.DiscoverPopularTopDTO
import com.github.rogerp91.mao_trailer_android.feature_movies.domain.MoviesRepository
import com.github.rogerp91.mao_trailer_android.feature_movies.ui.adapter.definition.MoviesModelAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val movies = MutableLiveData<List<MoviesModelAdapter>>()

    fun getData() {

    }

}
