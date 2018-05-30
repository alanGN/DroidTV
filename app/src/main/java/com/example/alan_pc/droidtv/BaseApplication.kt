package com.example.alan_pc.droidtv

import android.app.Application
import com.example.alan_pc.droidtv.di.component.ApplicationComponent
import com.example.alan_pc.droidtv.di.component.DaggerApplicationComponent
import com.example.alan_pc.droidtv.di.module.ApplicationModule

/**
 * Created by ALAN-PC on 26/05/2018
 */
class BaseApplication: Application() {

    private lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        configureDependencies()
    }

    private fun configureDependencies() {
        applicationComponent = buildApplicationComponent()
        applicationComponent.inject(this)
    }

    fun buildApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    /**
     * Retrieve the application component
     *
     * @return @{link ApplicationComponent}
     */
    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}