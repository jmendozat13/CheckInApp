package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.viewModelScope
import com.jmendozat13.checkinapp.delivery.navigation.HomeScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.LoginScreenGraphScreen
import com.jmendozat13.checkinapp.domain.entities.UserAccount
import com.jmendozat13.checkinapp.domain.usecases.RegisterUserAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserAccountViewModel @Inject constructor(private val registerUserAccount: RegisterUserAccount) :
    BaseViewModel() {


    fun onRegister(name: String, email: String, phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            registerUserAccount(UserAccount(name = name, email = email, phoneNumber = phoneNumber))
            mNavigationShareFlow.emit(HomeScreenGraphScreen)
        }
    }

    fun onLogin() {
        viewModelScope.launch(Dispatchers.Main) {
            mNavigationShareFlow.emit(LoginScreenGraphScreen)
        }
    }

}