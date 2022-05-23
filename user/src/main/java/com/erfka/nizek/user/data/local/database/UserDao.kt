package com.erfka.nizek.user.data.local.database

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT EXISTS(SELECT * FROM user WHERE username = :userName)")
    suspend fun userExists(userName: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(register: UserEntity)

    @Query("SELECT * FROM user WHERE username LIKE :userName")
    suspend fun getUserByUsername(userName: String): UserEntity?

}