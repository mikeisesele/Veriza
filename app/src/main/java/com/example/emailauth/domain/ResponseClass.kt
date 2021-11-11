package com.example.emailauth.domain

data class ResponseClass<T> (val message: String, val data: T, val status: Int ) {
}