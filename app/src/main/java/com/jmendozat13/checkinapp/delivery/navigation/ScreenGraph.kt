package com.jmendozat13.checkinapp.delivery.navigation

import kotlinx.serialization.Serializable

interface ScreenNavigationGraph
@Serializable object OnboardingScreenGraphScreen : ScreenNavigationGraph
@Serializable object LoginScreenGraphScreen : ScreenNavigationGraph
@Serializable object SignupScreenGraphScreen : ScreenNavigationGraph
@Serializable object HomeScreenGraphScreen :  ScreenNavigationGraph
@Serializable object LoadingScreenGraphScreen :  ScreenNavigationGraph
@Serializable object ResetIdentifierGraphScreen: ScreenNavigationGraph