package com.example.emailauth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.emailauth.network.ApiService
import com.example.emailauth.repository.LoginRepository

class LoginViewModelFactory(val retrofitApiService: ApiService):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(LoginRepository(retrofitApiService)) as T
    }
}