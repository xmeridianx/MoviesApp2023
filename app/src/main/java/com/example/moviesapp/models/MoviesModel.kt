package com.example.moviesapp.models

data class MoviesModel(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)