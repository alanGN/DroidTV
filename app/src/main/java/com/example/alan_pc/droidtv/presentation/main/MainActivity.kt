package com.example.alan_pc.droidtv.presentation.main

import com.example.alan_pc.droidtv.R
import com.example.alan_pc.droidtv.presentation.general.GeneralActivity
import com.example.alan_pc.droidtv.presentation.home.HomeFragment

class MainActivity : GeneralActivity() {

    override fun initResources() {
        supportFragmentManager.beginTransaction().add(
                R.id.activityMainFrameLayout,
                HomeFragment(), "tvShow").commit()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}