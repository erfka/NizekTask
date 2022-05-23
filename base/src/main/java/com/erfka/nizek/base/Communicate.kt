package com.erfka.nizek.base

class Communicate {

    interface WithUserModule {
        fun onSuccessfulLogin()
        fun onSuccessfulRegister()
        fun onSuccessfulLogout()
    }
}