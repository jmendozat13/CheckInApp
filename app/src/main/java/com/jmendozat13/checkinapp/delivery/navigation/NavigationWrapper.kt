package com.jmendozat13.checkinapp.delivery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jmendozat13.checkinapp.delivery.viewmodels.OrchestratorViewModel
import com.jmendozat13.checkinapp.delivery.views.screens.HomeScreen
import com.jmendozat13.checkinapp.delivery.views.screens.LoadingScreen
import com.jmendozat13.checkinapp.delivery.views.screens.LoginScreen
import com.jmendozat13.checkinapp.delivery.views.screens.OnboardingScreen
import com.jmendozat13.checkinapp.delivery.views.screens.SignupScreen

@Composable
fun NavigationWrapper(
    navController: NavHostController,
    orchestratorViewModel: OrchestratorViewModel
) {
    val startDestinationState by orchestratorViewModel.navigationState.collectAsState()

    NavHost(navController = navController, startDestination = startDestinationState) {
        composable<OnboardingScreenGraphScreen> {
            OnboardingScreen(navigateTo = {
                orchestratorViewModel.showOnboarding()
                navController.navigate(it) {
                    popUpTo<OnboardingScreenGraphScreen> { inclusive = true }
                }
            })
        }

        composable<LoginScreenGraphScreen> {
            LoginScreen {
                navController.navigate(HomeScreenGraphScreen) {
                    popUpTo<LoginScreenGraphScreen> { inclusive = true }
                    launchSingleTop = true
                }
            }
        }
        composable<SignupScreenGraphScreen> {
            SignupScreen {
                navController.navigate(HomeScreenGraphScreen) {
                    popUpTo<SignupScreenGraphScreen> { inclusive = true }
                    launchSingleTop = true
                }
            }
        }
        composable<HomeScreenGraphScreen> {
            HomeScreen()
        }
        composable<LoadingScreenGraphScreen> {
            LoadingScreen()
        }
    }
}