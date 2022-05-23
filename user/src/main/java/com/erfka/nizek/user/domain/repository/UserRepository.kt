package com.erfka.nizek.user.domain.repository

import com.erfka.nizek.user.domain.model.User

interface UserRepository {

    suspend fun userExists(userName: String): Boolean

    suspend fun insertUser(user: User)

    suspend fun getUserByUsername(userName: String): User?

}