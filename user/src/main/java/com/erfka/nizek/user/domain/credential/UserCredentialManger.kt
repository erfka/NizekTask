package com.erfka.nizek.user.domain.credential

interface UserCredentialManger {

    fun savePassword(username: String, password: String)

    fun passwordEnteredCorrectly(username: String, password: String): Boolean

}