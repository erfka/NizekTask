package com.erfka.nizek.user.presentation.viewmodel

import androidx.lifecycle.*
import com.erfka.nizek.base.ResultWrapper
import com.erfka.nizek.user.domain.credential.UserCredentialManger
import com.erfka.nizek.user.domain.interactor.InsertUserUseCase
import com.erfka.nizek.user.domain.interactor.UserExistsUseCase
import com.erfka.nizek.user.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userExistsUseCase: UserExistsUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val userCredentialManger: UserCredentialManger
) : ViewModel() {

    private val _tryRegisterUser = MutableLiveData<ResultWrapper<String>>()
    val tryRegisterUser = _tryRegisterUser

    fun registerIfUserNotExists(user: User, password: String) {
        viewModelScope.launch {

            _tryRegisterUser.postValue(ResultWrapper.Loading())

            if (!userExistsUseCase.invoke(user.username)) {
                insertUser(user, password)
            } else {
                _tryRegisterUser.postValue(ResultWrapper.Error("Username Exists!"))
            }

        }
    }

    private fun insertUser(user: User, password: String) {
        viewModelScope.launch {
            insertUserUseCase.invoke(user)
            userCredentialManger.savePassword(user.username, password)
            _tryRegisterUser.postValue(ResultWrapper.Success("User Registered Successfully"))
        }
    }


}