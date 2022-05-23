package com.erfka.nizek.user.domain.interactor

import com.erfka.nizek.user.domain.model.User
import com.erfka.nizek.user.domain.repository.UserRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User) = userRepository.insertUser(user)
}
