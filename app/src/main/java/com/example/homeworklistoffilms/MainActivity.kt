package com.example.homeworklistoffilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieList = Server.getMovie()
        val recycler = findViewById<RecyclerView>(R.id.rvMovieList)
        val adapter = MovieAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.setItems(movieList)

        val movieListNew = Server.getMovie()
        adapter.setItems(movieListNew)
    }
}