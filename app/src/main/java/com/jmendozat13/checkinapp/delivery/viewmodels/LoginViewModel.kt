package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.viewModelScope
import com.jmendozat13.checkinapp.data.sources.local.datastore.LocalDataStore
import com.jmendozat13.checkinapp.delivery.navigation.HomeScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.ResetIdentifierGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.SignupScreenGraphScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val localDataStore: LocalDataStore) :
    BaseNavigationViewModel() {
        
    fun onLogin(identifier: String) {
        viewModelScope.launch(Dispatchers.Main) {
            localDataStore.setUserLogin()
            mNavigationShareFlow.emit(HomeScreenGraphScreen)
        }
    }

    fun onSignUp() {
        viewModelScope.launch(Dispatchers.Main) {
            mNavigationShareFlow.emit(SignupScreenGraphScreen)
        }
    }

    fun onResetIdentifier() {
        viewModelScope.launch(Dispatchers.Main) {
            mNavigationShareFlow.emit(ResetIdentifierGraphScreen)
        }
    }
}