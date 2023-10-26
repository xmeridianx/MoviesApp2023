package com.example.moviesapp.view.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.retrofit.RetrofitRepository
import com.example.moviesapp.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(): ViewModel() {
    private val repository = RetrofitRepository()
    val liveData: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getMoviesRetrofit(){
        viewModelScope.launch {
            try {
                liveData.value = repository.getMovies()
            }catch (e: Exception){
                Log.d("Error" ,"${e.message}" )
            }
        }
    }
}