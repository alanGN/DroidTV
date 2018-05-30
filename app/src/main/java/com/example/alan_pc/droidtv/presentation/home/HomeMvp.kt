package com.example.alan_pc.droidtv.presentation.home

import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import com.example.alan_pc.droidtv.presentation.general.GeneralPresent
import com.example.alan_pc.droidtv.presentation.general.GeneralView

/**
 * Created by ALAN-PC on 26/05/2018
 */
interface HomeMvp {

    interface View : GeneralView {
        fun onResultOk(tvShowResponse: TvShowResponse)
    }

    interface Presenter : GeneralPresent {
        fun getTvShows(page:String)
    }
}