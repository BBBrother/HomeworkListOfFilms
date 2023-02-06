package com.example.homeworklistoffilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<FilmViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            viewModel.filmLiveData.observe()

        val movieList = Server.getMovie()
        val recycler = findViewById<RecyclerView>(R.id.rvMovieList)
        val adapter = MovieAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setItems(movieList)

        val movieListNew = Server.getMovie()
        adapter.setItems(movieListNew)


        val onClick:() -> Unit = {
            val opisanie = OpisanieFilmaFragment.newInstance("66")
        }
    }
}