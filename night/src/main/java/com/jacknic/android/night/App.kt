package com.jacknic.android.night

import android.app.Application

/**
 * 应用入口
 *
 * @author Jacknic
 */
class App : Application() {

    init {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }

    override fun onCreate() {
        super.onCreate()
    }
}