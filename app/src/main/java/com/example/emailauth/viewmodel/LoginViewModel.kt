package com.example.emailauth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emailauth.domain.Login
import com.example.emailauth.repository.LoginRepository
import com.example.emailauth.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private var _mutableLiveData = MutableLiveData<Resource<Login>>()
    val liveData: LiveData<Resource<Login>> get()  = _mutableLiveData

    fun login(loginDetails: Login) {
        _mutableLiveData.value = Resource.Loading(null)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _mutableLiveData.postValue(Resource.Success(loginRepository.loginNew(loginDetails)))
            } catch (e: Exception) {
                _mutableLiveData.postValue(Resource.Error(null, "an error occurred"))
            }
        }
    }
}