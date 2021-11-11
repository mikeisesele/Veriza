package com.example.emailauth.repository

import com.example.emailauth.domain.Login
import com.example.emailauth.network.ApiService

class LoginRepository(private val retrofitApiService: ApiService) {

    // suspend fun login(email: String, password:String) = retrofitApiService.register(email, password)
    suspend fun loginNew(login: Login) = retrofitApiService.login(login)


}

