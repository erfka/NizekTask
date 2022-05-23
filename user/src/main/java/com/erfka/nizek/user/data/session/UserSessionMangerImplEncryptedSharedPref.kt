package com.erfka.nizek.user.data.session

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.erfka.nizek.base.CommunicationModel
import com.erfka.nizek.user.domain.session.UserSessionManager

class UserSessionMangerImplEncryptedSharedPref(private val context: Context) : UserSessionManager {

    private val sharedPreferences: SharedPreferences

    init {

        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        sharedPreferences = EncryptedSharedPreferences.create(
            context,
            " com.erfka.nizek.user_SHARED_PREF",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    }

    override fun userIsLoggedIn(): Boolean {
        val pw = sharedPreferences.getString("password", "")
        return pw != null && pw.isNotEmpty()
    }


    override fun sessionIsExpired(sessionStartedAt: Long, sessionDuration: Long): Boolean {
        return System.currentTimeMillis() - sessionDuration > sessionStartedAt
    }

    override fun logoutUser() {
        sharedPreferences.edit().remove("password").apply()
        CommunicationModel.userModuleListener?.onSuccessfulLogout()
    }


}