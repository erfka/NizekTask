package com.erfka.nizek

import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import com.erfka.nizek.base.CommunicationModel
import com.erfka.nizek.user.data.session.UserSessionMangerImplEncryptedSharedPref
import com.erfka.nizek.user.domain.session.UserSessionManager
import dagger.hilt.android.HiltAndroidApp
import java.util.*


@HiltAndroidApp
class NizekApplication : Application() {
    var showSplash = true

    var timer: CountDownTimer? = null
    var loggedOut: Boolean = false

    init {
        instance = this
    }

    companion object {
        private var instance: NizekApplication? = null

        fun applicationContext(): NizekApplication {
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

    private fun isAppOnForeground(context: Context, appPackageName: String): Boolean {
        val activityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager.runningAppProcesses ?: return false
        for (appProcess in appProcesses) {
            if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName == appPackageName) {
                return true
            }
        }
        return false
    }

}