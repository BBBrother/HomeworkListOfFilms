package com.example.homeworklistoffilms

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun onBind(item: MovieData) {
        val number = itemView.findViewById<TextView>(R.id.rvNumberOfMovie)
        val poster = itemView.findViewById<ImageView>(R.id.rvPoster)
        val name = itemView.findViewById<TextView>(R.id.rvMovieName)
        val oscar = itemView.findViewById<ImageView>(R.id.rvOscar)
        val rating = itemView.findViewById<TextView>(R.id.rvRatingMovie)

        number.text = item.numberInList.toString()
        getPoster(item.poster, poster)
        name.text = item.name
        oscar.isVisible = item.oscarTrue
        rating.text = item.rating.toString()
    }

    private fun getPoster(url: String, poster: ImageView) {
        Glide.with(poster)
            .load(url)
            .into(poster)
    }
}