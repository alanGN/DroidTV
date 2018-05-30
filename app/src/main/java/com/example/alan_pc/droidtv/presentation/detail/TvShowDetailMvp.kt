package com.example.alan_pc.droidtv.presentation.detail

import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import com.example.alan_pc.droidtv.presentation.general.GeneralPresent
import com.example.alan_pc.droidtv.presentation.general.GeneralView

/**
 * Created by ALAN-PC on 26/05/2018
 */
interface TvShowDetailMvp {

    interface View : GeneralView {
        fun onResultOk(tvShowResponse: TvShowResponse)
    }

    interface Presenter : GeneralPresent {
        fun getSimilarTvShows(page:String,tv_id:String)
    }
}