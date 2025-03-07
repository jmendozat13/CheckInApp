package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmendozat13.checkinapp.data.LocalDataStore
import com.jmendozat13.checkinapp.delivery.navigation.LoadingScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.LoginScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.OnboardingScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrchestratorViewModel @Inject constructor(private val localDataStore: LocalDataStore) :
    ViewModel() {

    private val mNavigationState: MutableStateFlow<ScreenNavigationGraph> by lazy {
        MutableStateFlow(LoadingScreenGraphScreen)
    }
    val navigationState = mNavigationState.asStateFlow()

    init {
        startOrchestrator()
    }

    private fun startOrchestrator() {
        viewModelScope.launch(Dispatchers.Main) {
            val isShowOnboarding = localDataStore.getIsShowOnboarding()
            if (isShowOnboarding) {
                mNavigationState.emit(LoginScreenGraphScreen)
            } else {
                mNavigationState.emit(OnboardingScreenGraphScreen)
            }
        }
    }


    fun showOnboarding() {
        viewModelScope.launch(Dispatchers.Main) {
            localDataStore.setShowOnboarding()
        }
    }
}