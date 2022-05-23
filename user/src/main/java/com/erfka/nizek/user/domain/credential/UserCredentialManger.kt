package com.erfka.nizek.user.domain.credential

interface UserCredentialManger {

    fun saveUsernameAndPassword(username: String, password: String)

    fun passwordEnteredCorrectly(password: String): Boolean

    fun getUsername(): String

}