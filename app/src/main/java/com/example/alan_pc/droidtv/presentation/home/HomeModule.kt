package com.example.alan_pc.droidtv.presentation.home

import com.example.alan_pc.droidtv.di.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by ALAN-PC on 26/05/2018
 */
@Module
class HomeModule(private var view: HomeMvp.View) {

    @Provides
    @ActivityScope
    internal fun provideView(): HomeMvp.View {
        return view
    }

    @Provides
    @ActivityScope
    internal fun providePresenter(presenter : HomePresenter): HomeMvp.Presenter {
        return presenter
    }
}