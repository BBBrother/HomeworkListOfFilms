package com.example.homeworklistoffilms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworklistoffilms.databinding.RvItemMovieBinding

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {

    private val list: MutableList<MovieData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = RvItemMovieBinding.inflate(view, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setItems(list: List<MovieData>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}