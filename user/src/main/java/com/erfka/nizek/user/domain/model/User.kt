package com.erfka.nizek.user.domain.model

data class User(
    val fullName: String,
    val username: String,
    val modifiedAt: Long = System.currentTimeMillis()
)
