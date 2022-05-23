package com.erfka.nizek.user.domain.interactor

import com.erfka.nizek.user.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByUsernameUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(username: String) = userRepository.getUserByUsername(username)
}
