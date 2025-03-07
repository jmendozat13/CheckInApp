package com.jmendozat13.checkinapp.delivery.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import com.jmendozat13.checkinapp.delivery.navigation.SignupScreenGraphScreen

@Composable
fun OnboardingScreen(navigateTo: (ScreenNavigationGraph) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Text("ONBOARDING")
            Button(
                onClick = {
                    navigateTo(SignupScreenGraphScreen)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continuar")
            }
        }
    }

}