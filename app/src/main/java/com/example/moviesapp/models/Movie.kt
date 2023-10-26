package com.example.moviesapp.models

import java.io.Serializable


data class Movie(

    val id: Int,

    val overview: String,

    val poster_path: String,

    val release_date: String,

    val title: String,

) : Serializable