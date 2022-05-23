package com.erfka.nizek.base


sealed class ResultWrapper<T>(val successData: T? = null, val errorMessage: String? = null) {
    class Success<T>(data: T) : ResultWrapper<T>(data)
    class Error<T>(message: String, data: T? = null) : ResultWrapper<T>(data, message)
    class Loading<T>(data: T? = null) : ResultWrapper<T>(data)
}
