package com.erfka.nizek.user.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.erfka.nizek.base.CommunicationModel
import com.erfka.nizek.user.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {

    companion object {

        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, UserActivity::class.java))
        }

        fun start(fragment: Fragment) {
            fragment.startActivity(Intent(fragment.requireContext(), UserActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

    }
}