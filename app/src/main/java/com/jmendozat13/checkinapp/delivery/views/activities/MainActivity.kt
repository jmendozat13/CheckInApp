package com.jmendozat13.checkinapp.delivery.views.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jmendozat13.checkinapp.delivery.navigation.NavigationWrapper
import com.jmendozat13.checkinapp.delivery.theme.CheckInAppTheme
import com.jmendozat13.checkinapp.delivery.viewmodels.OrchestratorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val orchestratorViewModel: OrchestratorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            CheckInAppTheme {
                val navController: NavHostController = rememberNavController()
                val startDestinationState by orchestratorViewModel.navigationState.collectAsState()
                NavigationWrapper(navController, startDestinationState)
            }
        }
    }
}