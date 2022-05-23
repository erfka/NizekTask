package com.erfka.nizek.user.data.repository


import com.erfka.nizek.user.data.local.database.UserDao
import com.erfka.nizek.user.data.local.database.UserEntity
import com.erfka.nizek.user.data.mapper.UserMapper
import com.erfka.nizek.user.domain.model.User
import com.erfka.nizek.user.domain.repository.UserRepository

class UserRepositoryImpl(
    private val dao: UserDao,
    private val userMapper: UserMapper
) : UserRepository {

    override suspend fun userExists(userName: String): Boolean {
        return dao.userExists(userName)
    }

    override suspend fun insertUser(user: User) {
        return dao.insert(userMapper.toUserEntity(user))
    }

    override suspend fun getUserByUsername(userName: String): User? {
        return userMapper.toMutableUser(dao.getUserByUsername(userName))
    }

}