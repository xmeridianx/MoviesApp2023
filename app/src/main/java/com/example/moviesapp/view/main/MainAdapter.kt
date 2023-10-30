package com.example.moviesapp.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.IMAGE_URL
import com.example.moviesapp.R
import com.example.moviesapp.models.Movie
import com.example.moviesapp.view.detail.DetailFragment

class MainAdapter(private val listener: MovieItemClickListener): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var listMovies = mutableListOf<Movie>()

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.itemTextViewTitle).text = listMovies[position].title
        holder.itemView.findViewById<TextView>(R.id.itemTextViewDate).text = listMovies[position].release_date

        Glide.with(holder.itemView.context).load("$IMAGE_URL${listMovies[position].poster_path}").centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.findViewById<ImageView>(R.id.itemImageView))

        holder.itemView.setOnClickListener{
            listener.onMovieItemClick(listMovies[position])
        }
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }


    fun setListMovies(list: List<Movie>){
        listMovies.addAll(list)
        notifyDataSetChanged()
    }
}