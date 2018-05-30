package com.example.alan_pc.droidtv.presentation.detail.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alan_pc.droidtv.R
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShow
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tv_show_card.view.*

class SimilarTvShowAdapter(val tvShowList: MutableList<TvShow>, val listener: (TvShow) -> Unit) : RecyclerView.Adapter<SimilarTvShowAdapter.ViewHolder>() { //TODO IMPROVE A GENERAL ADAPTER FOR TV SHOWS AND GET ONE LAYOUT OR ANOTHER FOR ANY CASE

    fun addTvShowsToList(tvShowList: MutableList<TvShow>){
        this.tvShowList.addAll(tvShowList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvShowList[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_similar_tv_show_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: TvShow, listener: (TvShow) -> Unit) = with(itemView) {
            tvShowTitleTv.text = item.name
            tvShowAverageTv.text = item.vote_average.toInt().toString()
            Picasso.get().load("http://image.tmdb.org/t/p/w500"+item.backdrop_path).fit().centerCrop().into(tvShowCoverIv)
            setOnClickListener { listener(item) }
        }
    }
}