package com.example.moviesapp.data.retrofit.api

import com.example.moviesapp.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=72c16ebec00ee4f7973160b9cd0269ff&language=en-US&page=1")
    //https://api.themoviedb.org/3/movie/popular?api_key=72c16ebec00ee4f7973160b9cd0269ff&language=en-US&page=1
    //3/movie/popular?api_key=72c16ebec00ee4f7973160b9cd0269ff&language=en-US&page=1
    suspend fun getPopularMovies(): Response<MoviesModel>
}