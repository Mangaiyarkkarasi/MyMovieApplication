package com.example.mymovieapplication.MovieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovieapplication.data.repositories.MovieDetailRepository

class MovieDetailViewModelFactory(private val repository: MovieDetailRepository) :
    ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(repository) as T
    }
}