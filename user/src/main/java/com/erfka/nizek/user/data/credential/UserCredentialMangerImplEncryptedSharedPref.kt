package com.erfka.nizek.user.data.credential


import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.erfka.nizek.user.domain.credential.UserCredentialManger


class UserCredentialMangerImplEncryptedSharedPref(private val context: Context) : UserCredentialManger {

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


    override fun savePassword(username: String, password: String) {
        sharedPreferences.edit().putString(username, password).apply()
    }

    override fun passwordEnteredCorrectly(username: String, password: String): Boolean {
        val pw = sharedPreferences.getString(username, password)
        return pw != null && pw == password
    }

}