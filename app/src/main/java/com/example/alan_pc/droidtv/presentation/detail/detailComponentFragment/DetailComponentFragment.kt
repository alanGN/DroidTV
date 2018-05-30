package com.example.alan_pc.droidtv.presentation.detail.detailComponentFragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.alan_pc.droidtv.R
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShow
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import com.example.alan_pc.droidtv.presentation.detail.TvShowDetailActivity
import com.example.alan_pc.droidtv.presentation.general.EndlessRecyclerOnScrollListener
import com.example.alan_pc.droidtv.presentation.general.GeneralFragment
import com.example.alan_pc.droidtv.presentation.home.adapter.TvShowAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_tvshow_detail.*
import kotlinx.android.synthetic.main.item_tv_show_card.*
import kotlinx.android.synthetic.main.item_tv_show_card.view.*
import javax.inject.Inject

/**
 * Created by ALAN-PC on 26/05/2018
 */
class DetailComponentFragment : GeneralFragment() {

    companion object {
        private val TV_SHOW = "detailComponentFragment_tvShow"

        fun newInstance(tvShow: TvShow): DetailComponentFragment {
            val args: Bundle = Bundle()
            args.putSerializable(TV_SHOW, tvShow)
            val fragment = DetailComponentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_tvshow_detail
    }

    override fun initResources() {
        val arguments = arguments
        val tvShow = arguments!!.get(TV_SHOW) as TvShow
        textViewOverview.text = tvShow.overview
        tvShowTitleTv.text = tvShow.name
        tvShowAverageTv.text = tvShow.vote_average.toInt().toString()
        Picasso.get().load("http://image.tmdb.org/t/p/w500"+tvShow.backdrop_path).fit().centerCrop().into(tvShowCoverIv)
    }

}