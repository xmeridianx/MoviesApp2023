package com.example.moviesapp.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMainBinding
import com.example.moviesapp.models.Movie
import com.example.moviesapp.view.detail.DetailFragment
import com.example.moviesapp.view.main.viewmodel.MainFragmentViewModel


class MainFragment : Fragment(), MovieItemClickListener {
    private lateinit var binding: FragmentMainBinding
    //private val mainAdapter by lazy { MainAdapter() }
    private lateinit var mainAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainAdapter = MainAdapter(this)
        binding.recyclerViewMain.adapter = mainAdapter
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        viewModel.liveData.observe(viewLifecycleOwner, {moviesModel ->
            mainAdapter.setListMovies(moviesModel.results)
        })
        viewModel.loadMovies()

    }


    override fun onMovieItemClick(movie: Movie) {
        val bundle = Bundle()
        bundle.putSerializable("movie", movie)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, detailFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}



