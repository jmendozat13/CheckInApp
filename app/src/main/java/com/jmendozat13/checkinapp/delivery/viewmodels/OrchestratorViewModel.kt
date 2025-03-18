package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmendozat13.checkinapp.data.sources.local.datastore.LocalDataStore
import com.jmendozat13.checkinapp.delivery.navigation.HomeScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.LoadingScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.LoginScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.OnboardingScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
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
        viewModelScope.launch {
            val (isShowOnboarding, isUserLogin) = awaitAll(
                async { localDataStore.getIsShowOnboarding() },
                async { localDataStore.getIsUserLogin() }
            )
            val navigationState = when {
                isShowOnboarding -> {
                    if (isUserLogin) HomeScreenGraphScreen else LoginScreenGraphScreen
                }

                else -> OnboardingScreenGraphScreen
            }
            mNavigationState.emit(navigationState)
        }
    }

}