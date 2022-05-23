package com.erfka.nizek.base

object CommunicationModel {

    var userModuleListener: Communicate.WithUserModule? = null
        set(value) {
            if (value != null) field = value
        }


}