package com.example.alan_pc.droidtv.domain.mapper

import com.example.alan_pc.droidtv.data.entity.TvShowResponseDto
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShow
import com.example.alan_pc.droidtv.domain.business.tmdb.TvShowResponse
import javax.inject.Inject

/**
 * Created by ALAN-PC on 26/05/2018
 */
class TvShowMapper @Inject constructor() {

    fun convertTvShowResponseDtoToTvShowResponse(tvShowResponseDto: TvShowResponseDto): TvShowResponse{
        val tvShowList = mutableListOf<TvShow>()

        tvShowResponseDto.results.forEach {
            var tvShow = TvShow(it.poster_path, it.popularity, it.id, it.backdrop_path, it.vote_average, it.overview, it.first_air_date, it.origin_country, it.genre_ids, it.original_language,
                    it.vote_count, it.name, it.original_name)
            tvShowList.add(tvShow)
        }

        return TvShowResponse(tvShowList,tvShowResponseDto.page)
    }
}