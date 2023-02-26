package com.example.homeworklistoffilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworklistoffilms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityMainBinding
    private val viewModel by viewModels<FilmViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.goodDataName = viewModel
        binding.setLifecycleOwner (this)
        val adapter = MovieAdapter()
        binding.rvMovieList.adapter = adapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel.filmLiveData.observe(this) {movieList ->
            adapter.setItems(movieList)
        }

        viewModel.getFilm()


//        val movieListNew = Server.getMovie()
//        adapter.setItems(movieListNew)


        val onClick: () -> Unit = {
            val opisanie = OpisanieFilmaFragment.newInstance("66")
        }
    }
}