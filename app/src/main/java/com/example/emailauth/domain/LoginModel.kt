package com.example.emailauth.domain

data class LoginModel(val name: String, val email: String, val password:String) {

}

data class Login(val email: String, val password: String)
