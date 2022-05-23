package com.erfka.nizek.user.presentation.viewmodel

import androidx.lifecycle.*
import com.erfka.nizek.user.domain.credential.UserCredentialManger
import com.erfka.nizek.user.domain.interactor.GetUserByUsernameUseCase
import com.erfka.nizek.user.domain.interactor.InsertUserUseCase
import com.erfka.nizek.base.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserByUsernameUseCase: GetUserByUsernameUseCase,
    private val userCredentialManger: UserCredentialManger,
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {

    private val _tryLoginUser = MutableLiveData<ResultWrapper<String>>()
    val tryLoginUser = _tryLoginUser


    fun tryLoginUser(username: String, password: String) {
        viewModelScope.launch {

            _tryLoginUser.postValue(ResultWrapper.Loading())

            val user = getUserByUsernameUseCase.invoke(username)
            if (user != null) {
                if (userCredentialManger.passwordEnteredCorrectly(username, password)) {
                    insertUserUseCase.invoke(user)
                    _tryLoginUser.postValue(ResultWrapper.Success("User Logged In Successfully"))
                } else {
                    wrongCredentials()
                }
            } else {
                wrongCredentials()
            }
        }
    }

    private fun wrongCredentials() {
        _tryLoginUser.postValue(ResultWrapper.Error("Wrong Credentials!"))
    }

}