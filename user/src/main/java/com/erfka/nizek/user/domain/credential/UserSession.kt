package com.erfka.nizek.user.domain.credential

interface UserSession {

    fun sessionIsExpired(sessionStartedAt: Long, sessionDuration: Long): Boolean

    fun userIsLoggedIn(username: String, password: String): Boolean

    fun savePassword(username: String, password: String)

    fun passwordEnteredCorrectly(username: String, password: String): Boolean

}