package com.example.emailauth.util

sealed class Resource<out T>(val message: Any? = null, val data: String? = null) {

    class Success<T>(data: T): Resource<T>(data)
    class Error <T>(data:T? = null, message: String?): Resource<T>(data, message)
    class Loading<T>(data:T?): Resource<T>(data)
}
