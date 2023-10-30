package com.example.moviesapp.view.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.retrofit.MoviesRepository
import com.example.moviesapp.models.MoviesModel
import kotlinx.coroutines.launch

class MainFragmentViewModel(): ViewModel() {
    private val repository = MoviesRepository()
    //private val _movieList = MutableLiveData<List<Movie>>()
    //val movieList: LiveData<List<Movie>> get() = _movieList
    val liveData: MutableLiveData<MoviesModel> = MutableLiveData()

    fun loadMovies(){
        viewModelScope.launch {
            val result = repository.getMovies()
            if (result.isSuccess){
                liveData.value = result.getOrThrow()
            }else{
                val moviesModel = MoviesModel(0, emptyList(), 0, 0)
                liveData.value = moviesModel
            }
        }
    }
}