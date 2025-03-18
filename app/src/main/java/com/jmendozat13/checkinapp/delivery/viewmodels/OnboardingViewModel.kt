package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.viewModelScope
import com.jmendozat13.checkinapp.data.sources.local.datastore.LocalDataStore
import com.jmendozat13.checkinapp.delivery.navigation.SignupScreenGraphScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val localDataStore: LocalDataStore) :
    BaseNavigationViewModel() {


    fun onContinue() {
        viewModelScope.launch(Dispatchers.Main) {
            localDataStore.setShowOnboarding()
            mNavigationShareFlow.emit(SignupScreenGraphScreen)
        }
    }

}