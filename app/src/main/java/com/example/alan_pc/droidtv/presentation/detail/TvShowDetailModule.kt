package com.example.alan_pc.droidtv.presentation.detail

import com.example.alan_pc.droidtv.di.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by ALAN-PC on 26/05/2018
 */
@Module
class TvShowDetailModule(private var view: TvShowDetailMvp.View) {

    @Provides
    @ActivityScope
    internal fun provideView(): TvShowDetailMvp.View {
        return view
    }

    @Provides
    @ActivityScope
    internal fun providePresenter(presenter: TvShowDetailPresenter): TvShowDetailMvp.Presenter {
        return presenter
    }
}