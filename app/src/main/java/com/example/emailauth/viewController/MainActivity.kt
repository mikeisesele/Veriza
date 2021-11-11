package com.example.emailauth.viewController

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.emailauth.domain.Login
import com.example.emailauth.databinding.ActivityMainBinding
import com.example.emailauth.network.ApiService
import com.example.emailauth.network.RetrofitBuilder
import com.example.emailauth.util.Resource
import com.example.emailauth.viewmodel.LoginViewModel
import com.example.emailauth.viewmodel.LoginViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this, LoginViewModelFactory(RetrofitBuilder.retrofitApiService)).get(LoginViewModel::class.java)

        observeLogin()

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val phoneNumber = binding.phonenumberEditText.text.toString()
            val fullName = binding.fullnameEditText.text.toString()

            when {
                email.isEmpty() -> Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT)
                    .show()
                password.isEmpty() -> Toast.makeText(
                    this,
                    "Please Enter Password",
                    Toast.LENGTH_SHORT
                ).show()
                phoneNumber.isEmpty() -> Toast.makeText(
                    this,
                    "Please enter Phonenumber",
                    Toast.LENGTH_SHORT
                )
                    .show()
                fullName.isEmpty() -> Toast.makeText(
                    this,
                    "Please Enter Fullname",
                    Toast.LENGTH_SHORT
                ).show()

                else -> {
                    val loginCredentials = Login(email, password)

                    loginViewModel.login(loginCredentials)
                }
            }
        }

    }

    private fun observeLogin() {
        loginViewModel.liveData.observe(this, {
            when (it) {
                is Resource.Success -> Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT)
                    .show()
                is Resource.Error -> Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT)
                    .show()
                is Resource.Loading -> Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
            }
        })

    }

}