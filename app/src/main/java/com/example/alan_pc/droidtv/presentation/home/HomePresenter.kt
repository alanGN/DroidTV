package com.example.alan_pc.droidtv.presentation.home

import com.example.alan_pc.droidtv.domain.business.tmdb.TmdbBo
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import com.example.alan_pc.droidtv.domain.business.tmdb.interfaces.TvShowInterface
import javax.inject.Inject

/**
 * Created by ALAN-PC on 26/05/2018
 */
class HomePresenter @Inject constructor(var view: HomeMvp.View, var tmdbBo: TmdbBo) :
        HomeMvp.Presenter, TvShowInterface.getTvShows {

    override fun getTvShowsOk(tvShowResponse: TvShowResponse) {
        view.onResultOk(tvShowResponse)
    }

    override fun getTvShows(page:String) {
        tmdbBo.getTvShowList(view, this,page)
    }

    override fun unSubscribe() {
        tmdbBo.unSubscribe()
    }
}