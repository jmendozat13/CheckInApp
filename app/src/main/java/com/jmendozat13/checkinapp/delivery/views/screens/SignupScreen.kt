package com.jmendozat13.checkinapp.delivery.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import com.jmendozat13.checkinapp.delivery.theme.Header01_Bold
import com.jmendozat13.checkinapp.delivery.theme.Paragraph01_SemiBold
import com.jmendozat13.checkinapp.delivery.viewmodels.UserAccountViewModel
import com.jmendozat13.checkinapp.delivery.views.components.CustomButtonPrimary
import com.jmendozat13.checkinapp.delivery.views.components.CustomButtonPrimaryOutline
import com.jmendozat13.checkinapp.delivery.views.components.CustomSocialButtons
import com.jmendozat13.checkinapp.delivery.views.components.CustomTextField
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignupScreen(
    userAccountViewModel: UserAccountViewModel = hiltViewModel(),
    navigateTo: (ScreenNavigationGraph) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        var names by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(84.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                textAlign = TextAlign.Center,
                text = "Crear Cuenta",
                style = Header01_Bold
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                textAlign = TextAlign.Center,
                text = "Únete a nuestra comunidad de restaurantes y atrae más visitas",
                style = Paragraph01_SemiBold
            )
            Spacer(modifier = Modifier.height(44.dp))

            CustomTextField(
                label = "Nombres*",
                value = names, onChangeValue = {
                    names = it
                })
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                label = "Email*",
                value = email, onChangeValue = {
                    email = it
                })
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                label = "Celular*",
                value = phoneNumber, onChangeValue = {
                    phoneNumber = it
                })
            Spacer(modifier = Modifier.height(24.dp))

            CustomButtonPrimary(title = "Registrar") {
                userAccountViewModel.onRegister(
                    name = names,
                    email = email,
                    phoneNumber = phoneNumber
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            CustomButtonPrimaryOutline { userAccountViewModel.onLogin() }
            Spacer(modifier = Modifier.height(24.dp))
            CustomSocialButtons(title = "o ingresa con", onClickGoogle = {}, onClickFacebook = {})
        }
    }

    LaunchedEffect(Unit) {
        userAccountViewModel.navigation.collectLatest { navigateTo(it) }
    }
}