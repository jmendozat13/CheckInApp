package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmendozat13.checkinapp.delivery.navigation.HomeScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import com.jmendozat13.checkinapp.domain.entities.UserAccount
import com.jmendozat13.checkinapp.domain.usecases.RegisterUserAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserAccountViewModel @Inject constructor(private val registerUserAccount: RegisterUserAccount) :
    ViewModel() {

    private val mNavigationShareFlow: MutableSharedFlow<ScreenNavigationGraph> by lazy { MutableSharedFlow() }
    val navigation = mNavigationShareFlow.asSharedFlow()

    fun sendRegisterUserAccount(name: String, email: String, phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            registerUserAccount(UserAccount(name = name, email = email, phoneNumber = phoneNumber))
            mNavigationShareFlow.emit(HomeScreenGraphScreen)
        }
    }

}