package com.erfka.nizek

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NizekApplication : Application(){
    var showSplash = true
    init {
        instance = this
    }

    companion object {
        private var instance: NizekApplication? = null

        fun applicationContext() : NizekApplication {
            return instance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = NizekApplication.applicationContext()
    }
}