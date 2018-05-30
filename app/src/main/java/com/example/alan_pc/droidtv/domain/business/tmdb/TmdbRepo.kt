package com.example.alan_pc.droidtv.domain.business.tmdb

import com.example.alan_pc.droidtv.data.entity.TvShowResponseDto
import io.reactivex.Observable

/**
 * Created by ALAN-PC on 26/05/2018
 */
interface TmdbRepo {
    fun getTvShows(page:String): Observable<TvShowResponseDto>
    fun getSimilarTvShows(page:String,tv_id:String): Observable<TvShowResponseDto>
}