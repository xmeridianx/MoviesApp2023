package com.example.moviesapp.view.detail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.retrofit.MoviesRepository
import com.example.moviesapp.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailFragmentViewModel: ViewModel() {
    private val repository = MoviesRepository()
    private val _moviesLiveData = MutableLiveData<Result<MoviesModel>>()
    val moviesLiveData: LiveData<Result<MoviesModel>> get() = _moviesLiveData
    //val liveData: MutableLiveData<MoviesModel> = MutableLiveData()

    fun loadMovies() {
        viewModelScope.launch {
            val result = repository.getMovies()
            _moviesLiveData.postValue(result)
        }
    }
}