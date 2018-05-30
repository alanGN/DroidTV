package com.example.alan_pc.droidtv.presentation.general

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.example.alan_pc.droidtv.BaseApplication
import com.example.alan_pc.droidtv.di.component.ApplicationComponent

/**
 * Created by ALAN-PC on 25/05/2018
 */

abstract class GeneralActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initializeDependencies()
        initResources()
    }

    /**
     * Template to set the layout ID
     */
    @LayoutRes protected abstract fun getLayoutId() : Int

    /**
     * Template to set texts
     */
    protected abstract fun initResources()

    /**
     * Template to initialize dependencies
     */
    protected open fun initializeDependencies() {

    }

    /**
     * Retrieve the application component
     * @return
     */
    protected fun getApplicationComponent(): ApplicationComponent {
        return (applicationContext as BaseApplication).getApplicationComponent()
    }
}