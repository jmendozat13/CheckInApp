package com.jmendozat13.checkinapp.delivery.views.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jmendozat13.checkinapp.delivery.theme.BlueGray900
import com.jmendozat13.checkinapp.delivery.theme.Header04_Bold
import com.jmendozat13.checkinapp.delivery.theme.Header05_SemiBold
import com.jmendozat13.checkinapp.delivery.theme.Light01
import com.jmendozat13.checkinapp.delivery.viewmodels.ResetIdentifierViewModel
import com.jmendozat13.checkinapp.delivery.views.components.CustomButtonPrimary
import com.jmendozat13.checkinapp.delivery.views.components.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetIdentifierScreen(
    resetIdentifierViewModel: ResetIdentifierViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Light01,
                    titleContentColor = BlueGray900,
                ),
                title = {
                    Text("Restablecer Identificador", style = Header04_Bold)
                }
            )
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Light01)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Le enviaremos el identificador asociado por email",
                style = Header05_SemiBold,
                textAlign = TextAlign.Center,
                color = BlueGray900
            )

            var email by remember { mutableStateOf("") }

            CustomTextField(
                label = "Email",
                value = email, onChangeValue = { email = it })

            CustomButtonPrimary(title = "Enviar") {
                resetIdentifierViewModel.sendEmailToResetIdentifier(email)
            }
        }
    }
}