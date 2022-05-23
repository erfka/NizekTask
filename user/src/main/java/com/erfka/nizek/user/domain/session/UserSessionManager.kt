package com.erfka.nizek.user.domain.session

interface UserSessionManager {

    fun userIsLoggedIn(username: String, password: String): Boolean

    fun sessionIsExpired(sessionStartedAt: Long, sessionDuration: Long): Boolean

    fun logoutUser(username: String)

}