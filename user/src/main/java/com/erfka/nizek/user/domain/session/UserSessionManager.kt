package com.erfka.nizek.user.domain.session

interface UserSessionManager {

    fun userIsLoggedIn(): Boolean

    fun sessionIsExpired(sessionStartedAt: Long, sessionDuration: Long): Boolean

    fun logoutUser()

}