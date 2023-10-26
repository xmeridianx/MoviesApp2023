package com.example.moviesapp.data.retrofit

import com.example.moviesapp.data.retrofit.api.RetrofitInstance
import com.example.moviesapp.models.MoviesModel
import retrofit2.Response

class RetrofitRepository{
    suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovies()
    }
}