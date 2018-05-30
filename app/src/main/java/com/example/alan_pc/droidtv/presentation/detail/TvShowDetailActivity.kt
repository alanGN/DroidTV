package com.example.alan_pc.droidtv.presentation.detail

import android.content.Context
import android.content.Intent
import android.support.v4.app.NavUtils
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.example.alan_pc.droidtv.R
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShow
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import com.example.alan_pc.droidtv.presentation.detail.adapter.SimilarTvShowAdapter
import com.example.alan_pc.droidtv.presentation.detail.detailComponentFragment.DetailComponentFragment
import com.example.alan_pc.droidtv.presentation.general.EndlessRecyclerOnScrollListener
import com.example.alan_pc.droidtv.presentation.general.GeneralActivity
import kotlinx.android.synthetic.main.activity_tvshow_detail.*
import javax.inject.Inject


class TvShowDetailActivity : GeneralActivity(), TvShowDetailMvp.View {

    var page: Int = 1
    private lateinit var adapter: SimilarTvShowAdapter

    @Inject
    lateinit var presenter: TvShowDetailMvp.Presenter

    override fun onResultOk(tvShowResponse: TvShowResponse) {
        if (page == 1) {
            adapter = SimilarTvShowAdapter(tvShowResponse.tvShowList, { tvShow: TvShow -> tvShowItemClicked(tvShow) })
            recyclerViewSimilarShows.adapter = adapter
        } else {
            adapter.addTvShowsToList(tvShowResponse.tvShowList)
        }
    }

    override fun onResultError(errorString: String?) {
        Toast.makeText(this, errorString, Toast.LENGTH_SHORT).show()
    }


    override fun initResources() {

        val tvShow = intent.extras.get(TV_SHOW) as TvShow

        supportFragmentManager.beginTransaction().add(
                R.id.tvShowDetailFl,
                DetailComponentFragment.newInstance(tvShow), "DetailtvShow").commit()

        toolbar.title = ""
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        presenter.getSimilarTvShows(page.toString(), tvShow.id.toString())

        recyclerViewSimilarShows.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)

        recyclerViewSimilarShows.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                page += 1
                presenter.getSimilarTvShows(page.toString(), tvShow.id.toString())
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun initializeDependencies() {
        super.initializeDependencies()
        getApplicationComponent().plus(TvShowDetailModule(this)).inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unSubscribe()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_tvshow_detail
    }

    companion object {
        private val TV_SHOW = "tvShow"
        private val TV_SHOW2="TVSHOW"
        fun newIntent(context: Context, tvShow: TvShow): Intent {
            val intent = Intent(context, TvShowDetailActivity::class.java)
            intent.putExtra(TV_SHOW, tvShow)
            return intent
        }
    }

    private fun tvShowItemClicked(tvShow: TvShow) {

        supportFragmentManager.beginTransaction().replace(
                R.id.tvShowDetailFl,
                DetailComponentFragment.newInstance(tvShow), "DetailtvShow").commit()
    }
}