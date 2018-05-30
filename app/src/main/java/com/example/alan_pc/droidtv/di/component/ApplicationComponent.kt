package com.example.alan_pc.droidtv.di.component

import com.example.alan_pc.droidtv.BaseApplication
import com.example.alan_pc.droidtv.di.module.ApplicationModule
import com.example.alan_pc.droidtv.di.module.NetworkModule
import com.example.alan_pc.droidtv.di.module.StorageModule
import com.example.alan_pc.droidtv.presentation.detail.TvShowDetailComponent
import com.example.alan_pc.droidtv.presentation.detail.TvShowDetailModule
import com.example.alan_pc.droidtv.presentation.home.HomeComponent
import com.example.alan_pc.droidtv.presentation.home.HomeModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ALAN-PC on 26/05/2018
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class, StorageModule::class))
abstract class ApplicationComponent {
    abstract fun inject(application: BaseApplication)
    abstract fun plus(module: HomeModule): HomeComponent
    abstract fun plus(module: TvShowDetailModule): TvShowDetailComponent
}