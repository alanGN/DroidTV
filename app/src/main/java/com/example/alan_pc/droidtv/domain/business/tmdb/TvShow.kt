package com.example.alan_pc.droidtv.domain.business.tmdb

import java.io.Serializable

/**
 * Created by ALAN-PC on 26/05/2018
 */
class TvShow(var poster_path: String, var popularity: Number, var id: Int, var backdrop_path: String, var vote_average: Number, var overview: String, var first_air_date: String,
             var origin_country: List<String>, var genre_ids: List<Int>, var original_language: String, var vote_count: Int, var name: String, var original_name: String) : Serializable{
}