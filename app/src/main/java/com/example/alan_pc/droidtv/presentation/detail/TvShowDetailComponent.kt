package com.example.alan_pc.droidtv.presentation.detail

import com.example.alan_pc.droidtv.di.ActivityScope
import dagger.Subcomponent

/**
 * Created by ALAN-PC on 26/05/2018
 */
@Subcomponent(modules = arrayOf(TvShowDetailModule::class))
@ActivityScope
interface TvShowDetailComponent {
    fun inject(activity: TvShowDetailActivity)
}