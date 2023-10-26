package com.example.moviesapp.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.databinding.FragmentMainBinding



class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val mainAdapter by lazy { MainAdapter() }


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

        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        binding.recyclerViewMain.adapter = mainAdapter
        viewModel.getMoviesRetrofit()
        viewModel.liveData.observe(viewLifecycleOwner, {list ->
            mainAdapter.setListMovies(list.body()!!.results)
        })

    }
}



