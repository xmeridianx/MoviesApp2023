package com.example.moviesapp.data.retrofit

import android.util.Log
import com.example.moviesapp.data.retrofit.api.RetrofitInstance
import com.example.moviesapp.models.MoviesModel

class MoviesRepository{
    suspend fun getMovies(): Result<MoviesModel> {
        try {
            val responce = RetrofitInstance.api.getPopularMovies()

            if (responce.isSuccessful) {
                val responceBody = responce.body()
                if (responceBody != null) {
                    return Result.success(responceBody)
                } else {
                    return Result.failure(Throwable("error, responce is null"))
                }
            } else {
                return Result.failure(Throwable("MoviesResponce error"))
            }
        }catch (e: Throwable){
            Log.d("RetrofitRepositoryError", "$e")
            return Result.failure(e)
        }
    }
}