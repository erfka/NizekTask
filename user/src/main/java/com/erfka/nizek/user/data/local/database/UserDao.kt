package com.erfka.nizek.user.data.local.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(register: UserEntity): Long

    @Query("SELECT * FROM user ORDER BY id DESC")
    suspend fun getAllUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE username LIKE :userName")
    suspend fun getUserByUsername(userName: String): UserEntity?


}