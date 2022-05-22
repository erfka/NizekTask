package com.erfka.nizek.user.data.repository


import com.erfka.nizek.user.data.local.database.UserDao
import com.erfka.nizek.user.data.local.database.UserEntity
import com.erfka.nizek.user.data.mapper.UserMapper
import com.erfka.nizek.user.domain.model.User
import com.erfka.nizek.user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val dao: UserDao,
    private val userMapper: UserMapper
) : UserRepository {

    override suspend fun insertUser(user: UserEntity): Long {
        return dao.insert(user)
    }

    override suspend fun getAllUsers(): Flow<List<User>> {
        val usersFlow = dao.getAllUsers()
        return usersFlow.map { list ->
            list.map { element ->
                userMapper.toUser(element)
            }
        }
    }

    override suspend fun getUserByUsername(userName: String): User? {
        return userMapper.toMutableUser(dao.getUserByUsername(userName))
    }

}