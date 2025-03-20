package com.jmendozat13.checkinapp.delivery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jmendozat13.checkinapp.delivery.views.screens.HomeScreen
import com.jmendozat13.checkinapp.delivery.views.screens.LoadingScreen
import com.jmendozat13.checkinapp.delivery.views.screens.LoginScreen
import com.jmendozat13.checkinapp.delivery.views.screens.OnboardingScreen
import com.jmendozat13.checkinapp.delivery.views.screens.ResetIdentifierScreen
import com.jmendozat13.checkinapp.delivery.views.screens.SignupScreen

@Composable
fun NavigationWrapper(
    navController: NavHostController,
    startDestination: ScreenNavigationGraph
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable<OnboardingScreenGraphScreen> {
            OnboardingScreen(navigateTo = {
                navController.navigate(it) {
                    popUpTo<OnboardingScreenGraphScreen> { inclusive = true }
                }
            })
        }

        composable<LoginScreenGraphScreen> {
            LoginScreen { destination ->
                when (destination) {
                    is HomeScreenGraphScreen, SignupScreenGraphScreen -> {
                        navController.navigate(destination) {
                            popUpTo<LoginScreenGraphScreen> { inclusive = true }
                            launchSingleTop = true
                        }
                    }

                    else ->
                        navController.navigate(destination)
                }
            }
        }

        composable<SignupScreenGraphScreen> {
            SignupScreen { destination ->
                when (destination) {
                    is HomeScreenGraphScreen, LoginScreenGraphScreen -> {
                        navController.navigate(destination) {
                            popUpTo<SignupScreenGraphScreen> { inclusive = true }
                            launchSingleTop = true
                        }
                    }

                    else -> navController.navigate(destination)
                }

            }
        }
        composable<HomeScreenGraphScreen> {
            HomeScreen()
        }
        composable<LoadingScreenGraphScreen> {
            LoadingScreen()
        }
        composable<ResetIdentifierGraphScreen> {
            ResetIdentifierScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}