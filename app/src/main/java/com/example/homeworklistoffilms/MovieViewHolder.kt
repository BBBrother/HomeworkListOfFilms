package com.example.homeworklistoffilms

import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homeworklistoffilms.databinding.RvItemMovieBinding

class MovieViewHolder(private val itemMovieBinding: RvItemMovieBinding): RecyclerView.ViewHolder(itemMovieBinding.root) {

    fun onBind(item: MovieData) {
        itemMovieBinding.rvNumberOfMovie.text = item.numberInList.toString()
        getPoster(item.poster, itemMovieBinding.rvPoster)
        itemMovieBinding.rvMovieName.text = item.name
        itemMovieBinding.rvOscar.isVisible = item.oscarTrue
        itemMovieBinding.rvRatingMovie.text = item.rating.toString()
    }

    private fun getPoster(url: String, poster: ImageView) {
        Glide.with(poster)
            .load(url)
            .into(poster)
    }
}