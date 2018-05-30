package com.example.alan_pc.droidtv.domain.business.tmdb

import com.example.alan_pc.droidtv.data.entity.TvShowResponseDto
import com.example.alan_pc.droidtv.domain.business.tmdb.interfaces.TvShowInterface
import com.example.alan_pc.droidtv.domain.mapper.TvShowMapper
import com.example.alan_pc.droidtv.presentation.general.GeneralView
import com.example.alan_pc.droidtv.presentation.general.reactive.GeneralBoImpl
import com.example.alan_pc.droidtv.presentation.general.reactive.GeneralSubscriber
import javax.inject.Inject

/**
 * Created by ALAN-PC on 26/05/2018
 */
class TmdbBo @Inject constructor(var tmdbRepo: TmdbRepo, var tvShowMapper: TvShowMapper) : GeneralBoImpl() {

    /**
     * get tvShowList
     * PARAMS
     * view : generalView to respond generic errors
     */
    fun getTvShowList(view: GeneralView, tvShowInterface: TvShowInterface.getTvShows, page:String) {
        execute(tmdbRepo.getTvShows(page), object : GeneralSubscriber<TvShowResponseDto, TvShowResponse>(view) {
            override fun onSuccess(tvShows: TvShowResponse) {
                tvShowInterface.getTvShowsOk(tvShows)
            }

            override fun mapperResponseDto(t: TvShowResponseDto): TvShowResponse {
                return tvShowMapper.convertTvShowResponseDtoToTvShowResponse(t)
            }

            override fun isValid(t: TvShowResponseDto): Boolean {
                return t.total_results > 0
            }
        })
    }

    /**
     * get tvShowList
     * PARAMS
     * view : generalView to respond generic errors
     */
    fun getSimilarTvShows(view: GeneralView, tvShowInterface: TvShowInterface.getTvShows, page:String, tv_id:String) {
        execute(tmdbRepo.getSimilarTvShows(page,tv_id), object : GeneralSubscriber<TvShowResponseDto, TvShowResponse>(view) {
            override fun onSuccess(tvShows: TvShowResponse) {
                tvShowInterface.getTvShowsOk(tvShows)
            }

            override fun mapperResponseDto(t: TvShowResponseDto): TvShowResponse {
                return tvShowMapper.convertTvShowResponseDtoToTvShowResponse(t)
            }

            override fun isValid(t: TvShowResponseDto): Boolean {
                return t.total_results > 0
            }
        })
    }

}