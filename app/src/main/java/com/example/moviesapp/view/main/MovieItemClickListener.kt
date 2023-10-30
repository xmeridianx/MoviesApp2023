package com.example.moviesapp.view.main

import com.example.moviesapp.models.Movie

interface MovieItemClickListener {
    fun onMovieItemClick(movie: Movie)
}