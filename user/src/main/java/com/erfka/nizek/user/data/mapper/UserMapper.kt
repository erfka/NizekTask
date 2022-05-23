package com.erfka.nizek.user.data.mapper

import com.erfka.nizek.user.data.local.database.UserEntity
import com.erfka.nizek.user.domain.model.User

class UserMapper {

    fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            fullName = user.fullName,
            username = user.username,
            modifiedAt = user.modifiedAt
        )
    }

    fun toMutableUser(userEntity: UserEntity?): User? {
        return userEntity?.let { toUser(it) }
    }

    fun toUser(userEntity: UserEntity): User {
        return User(
            fullName = userEntity.fullName,
            username = userEntity.username,
            modifiedAt = userEntity.modifiedAt
        )
    }
}