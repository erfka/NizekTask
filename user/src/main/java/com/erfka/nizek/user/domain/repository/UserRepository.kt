package com.erfka.nizek.user.domain.repository


import com.erfka.nizek.user.data.local.database.UserEntity
import com.erfka.nizek.user.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: UserEntity): Long

    suspend fun getAllUsers(): Flow<List<User>>

    suspend fun getUserByUsername(userName: String): User?

}