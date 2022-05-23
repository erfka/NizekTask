package com.erfka.nizek

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.erfka.nizek.base.Communicate
import com.erfka.nizek.base.CommunicationModel
import com.erfka.nizek.databinding.ActivityMainBinding
import com.erfka.nizek.user.domain.session.UserSessionManager
import com.erfka.nizek.user.presentation.UserActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Communicate.WithUserModule {


    private lateinit var appBarConfiguration: AppBarConfiguration

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    @Inject
    lateinit var userSessionManager: UserSessionManager


    companion object {

        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, MainActivity::class.java))
        }

        fun start(fragment: Fragment) {
            fragment.startActivity(Intent(fragment.requireContext(), MainActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {

//        if (NizekApplication.applicationContext().showSplash) {
//            installSplashScreen().setKeepOnScreenCondition {
//                false
//            }
//        }

        super.onCreate(savedInstanceState)
        CommunicationModel.userModuleListener = this
        settingUpMainActivity()
    }


    private fun settingUpMainActivity() {
        if (!userSessionManager.userIsLoggedIn()) {
            installSplashScreen()
            //splashScreen.
            UserActivity.start(this)
            finish()
        } else {
            setTheme(R.style.AppTheme)
            setContentView(binding.root)
            setupViews()
        }
    }

    private fun setupViews() {
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onSuccessfulLogin() {
        restartMainActivity()
        NizekApplication.applicationContext().loggedOut = false
    }

    override fun onSuccessfulRegister() {
    }

    override fun onSuccessfulLogout() {
        if (!NizekApplication.applicationContext().loggedOut) {
            restartMainActivity()
        } else {
            finish()
        }

        NizekApplication.applicationContext().loggedOut = true
        NizekApplication.applicationContext().timer?.cancel()
        NizekApplication.applicationContext().timer = null
    }

    private fun restartMainActivity() {
        val intent = Intent(this, this::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP
        )
        NizekApplication.applicationContext().showSplash = false
        startActivity(intent)
    }

    //***********************


    override fun onStart() {
        super.onStart()
        Log.d("timerTag", "onStart()")
        timerForLogout(30000)
    }


    override fun onStop() {
        super.onStop()
        Log.d("timerTag", "onStop()")
        if (NizekApplication.applicationContext().loggedOut){
            NizekApplication.applicationContext().timer?.cancel()
            NizekApplication.applicationContext().timer = null
            return
        }

        timerForLogout(10000)
    }


    private fun timerForLogout(millisInFuture: Long) {

        NizekApplication.applicationContext().timer?.cancel()
        NizekApplication.applicationContext().timer = null

        var n = millisInFuture / 1000

        NizekApplication.applicationContext().timer = object : CountDownTimer(millisInFuture, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                --n
                Log.d("timerTag", "onTick - $n - ${this.hashCode()}")
            }

            override fun onFinish() {
                Log.d("timerTag", "onFinish - $n - ${this.hashCode()}")
                userSessionManager.logoutUser()
            }
        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("timerTag", "onDestroy()")
        //timer?.cancel();
        //timer = null;
    }

}