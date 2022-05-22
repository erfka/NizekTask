package com.erfka.nizek.user.data.local.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "user" , indices = [Index(value = ["username"], unique = true)])
data class UserEntity(
    @PrimaryKey val id: Int = 0,
    val fullName: String,
    val username: String,
    val modifiedAt: Long
)
