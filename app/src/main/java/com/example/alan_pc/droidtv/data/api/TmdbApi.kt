package com.example.alan_pc.droidtv.data.api

import com.example.alan_pc.droidtv.BuildConfig
import com.example.alan_pc.droidtv.data.entity.TvShowResponseDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Alan on 25/05/2018
 */

interface TmdbApi {

    @Headers(BuildConfig.WB_CONTENT_TYPE_KEY + BuildConfig.WB_CONTENT_TYPE_VALUE, "Accept: application/json")
    @GET("tv/popular")
    fun getTvShows(@Query("api_key") api_key: String, @Query("page") page: String): Observable<TvShowResponseDto>

    @Headers(BuildConfig.WB_CONTENT_TYPE_KEY + BuildConfig.WB_CONTENT_TYPE_VALUE, "Accept: application/json")
    @GET("tv/{tv_id}/similar")
    fun getSimilarTvShows(@Path("tv_id") tv_id: String, @Query("api_key") api_key: String, @Query("page") page: String) : Observable<TvShowResponseDto>

}