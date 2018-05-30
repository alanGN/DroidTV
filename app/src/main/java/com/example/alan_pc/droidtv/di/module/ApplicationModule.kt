package com.example.alan_pc.droidtv.di.module

import android.app.Application
import android.app.Service
import android.content.Context
import android.content.res.Resources
import com.example.alan_pc.droidtv.data.repository.TmdbRepoImpl
import com.example.alan_pc.droidtv.domain.business.tmdb.TmdbRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ALAN-PC on 26/05/2018
 */
@Module
class ApplicationModule {
    private lateinit var application : Application
    private lateinit var service : Service
    private var context : Context

    constructor(application: Application){
        context = application.applicationContext
        this.application = application
    }

    constructor(service: Service){
        context = service.applicationContext
        this.service = service
    }

    @Provides
    @Singleton
    fun provideApplication() : Application {
        return application
    }

    @Provides
    @Singleton
    fun provideContext() : Context {
        return context
    }

    @Provides
    @Singleton
    fun provideResources() : Resources {
        return context.resources
    }

    @Provides
    fun provideTmdbRepository(tmdbRepoImpl: TmdbRepoImpl)
            : TmdbRepo {
        return tmdbRepoImpl;
    }
}