package com.tranhuuphuc.kotlinkoincoroutinemvvm.features.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tranhuuphuc.kotlinkoincoroutinemvvm.R
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    private var items = ArrayList<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
            HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun getItemCount(): Int = if (items.isNullOrEmpty()) 0 else items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val movie = items[position]
        holder.bindData(movie)
    }

    fun initData(data: ArrayList<Movie>?) {
        data?.let {
            items.addAll(data)
            notifyDataSetChanged()
        }
    }
}

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(movie: Movie) = with(itemView) {
        tvMovieName.text = movie.title
    }
}