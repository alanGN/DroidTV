package com.example.alan_pc.droidtv.presentation.home

import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * Created by ALAN-PC on 26/05/2018
 */
class HomeFragment : GeneralFragment(), HomeMvp.View {

    var page: Int = 1
    private lateinit var adapter: TvShowAdapter

    override fun onResultOk(tvShowResponse: TvShowResponse) {
        Log.d("PAGES", tvShowResponse.page.toString())
        Log.d("ITEMS", tvShowResponse.tvShowList.size.toString())

        if(page==1){
            adapter = TvShowAdapter(tvShowResponse.tvShowList, { tvShow: TvShow -> tvShowItemClicked(tvShow) })
            recyclerView.adapter = adapter
        }else{
            adapter.addTvShowsToList(tvShowResponse.tvShowList)
        }
    }

    @Inject
    lateinit var presenter: HomeMvp.Presenter

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initResources() {
        presenter.getTvShows(page.toString()) //First time

        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        recyclerView.addOnScrollListener(object : EndlessRecyclerOnScrollListener(){
            override fun onLoadMore() {
                page+=1
                presenter.getTvShows(page.toString())
            }
        })
    }

    override fun initializeDependencies() {
        super.initializeDependencies()
        getApplicationComponent().plus(HomeModule(this)).inject(this)
    }


    override fun onResultError(errorString: String?) {
        Toast.makeText(activity, errorString, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unSubscribe()
    }

    private fun tvShowItemClicked(tvShow: TvShow) {
        //Toast.makeText(context, "Clicked: ${tvShow.name}", Toast.LENGTH_LONG).show()
        val intent = TvShowDetailActivity.newIntent(context!!,tvShow)
        startActivity(intent)
    }
}