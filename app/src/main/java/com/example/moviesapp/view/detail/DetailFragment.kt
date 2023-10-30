package com.example.moviesapp.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.moviesapp.IMAGE_URL
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentDetailBinding
import com.example.moviesapp.models.Movie
import com.example.moviesapp.view.detail.viewmodel.DetailFragmentViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getSerializable("movie") as Movie
        val viewModel = DetailFragmentViewModel()
        binding.textViewDetailDate.text = movie.release_date
        binding.textViewDetailDescription.text = movie.overview
        Glide.with(requireContext())
            .load("$IMAGE_URL${movie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imageViewDetail)


    }
}