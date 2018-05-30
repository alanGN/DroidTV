package com.example.alan_pc.droidtv.presentation.detail

import com.example.alan_pc.droidtv.domain.business.tmdb.TmdbBo
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import com.example.alan_pc.droidtv.domain.business.tmdb.interfaces.TvShowInterface
import javax.inject.Inject

/**
 * Created by ALAN-PC on 26/05/2018
 */
class TvShowDetailPresenter @Inject constructor(var view: TvShowDetailMvp.View, var tmdbBo: TmdbBo) :
        TvShowDetailMvp.Presenter, TvShowInterface.getTvShows {

    override fun getSimilarTvShows(page: String, tv_id: String) {
        tmdbBo.getSimilarTvShows(view, this, page,tv_id)
    }

    override fun getTvShowsOk(tvShowResponse: TvShowResponse) {
        view.onResultOk(tvShowResponse)
    }

    override fun unSubscribe() {
        tmdbBo.unSubscribe()
    }
}