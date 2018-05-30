package com.example.alan_pc.droidtv.domain.business.tmdb.interfaces

import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse

/**
 * Created by ALAN-PC on 26/05/2018
 */
interface TvShowInterface {

    interface getTvShows {
        fun getTvShowsOk(tvShowResponse: TvShowResponse)
    }

}