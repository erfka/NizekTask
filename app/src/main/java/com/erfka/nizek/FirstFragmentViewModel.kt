package com.erfka.nizek

import androidx.lifecycle.*
import com.erfka.nizek.user.domain.credential.UserCredentialManger
import com.erfka.nizek.user.domain.interactor.GetUserByUsernameUseCase

import com.erfka.nizek.user.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val getUserByUsernameUseCase: GetUserByUsernameUseCase,
    private val userCredentialManger: UserCredentialManger
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user = _user

    fun getUser() {
        viewModelScope.launch {
            _user.postValue(getUserByUsernameUseCase.invoke(userCredentialManger.getUsername()))
        }
    }


}