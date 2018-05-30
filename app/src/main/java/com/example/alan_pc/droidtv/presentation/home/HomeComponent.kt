package com.example.alan_pc.droidtv.presentation.home

import com.example.alan_pc.droidtv.di.ActivityScope
import dagger.Subcomponent

/**
 * Created by ALAN-PC on 26/05/2018
 */
@Subcomponent(modules = arrayOf( HomeModule::class ))
@ActivityScope
interface HomeComponent {
    fun inject(fragment : HomeFragment)
}