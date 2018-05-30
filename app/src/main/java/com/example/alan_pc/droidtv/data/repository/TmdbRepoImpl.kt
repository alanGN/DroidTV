package com.example.alan_pc.droidtv.data.repository

import com.example.alan_pc.droidtv.BuildConfig
import com.example.alan_pc.droidtv.data.api.TmdbApi
import com.example.alan_pc.droidtv.data.entity.TvShowResponseDto
import com.example.alan_pc.droidtv.domain.business.tmdb.TmdbRepo
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by jcarballo on 03/04/2018.
 */
class TmdbRepoImpl @Inject constructor(val tmdbApi: TmdbApi) : TmdbRepo {

    override fun getTvShows(page:String): Observable<TvShowResponseDto> {
        return tmdbApi.getTvShows(BuildConfig.WB_BASIC,page) //TODO CHANGE BUILDCONFIG PARAMETER WITH CORRECT METHODS
    }

    override fun getSimilarTvShows(page: String, tv_id: String): Observable<TvShowResponseDto>{
        return tmdbApi.getSimilarTvShows(tv_id,BuildConfig.WB_BASIC,page)
    }
}