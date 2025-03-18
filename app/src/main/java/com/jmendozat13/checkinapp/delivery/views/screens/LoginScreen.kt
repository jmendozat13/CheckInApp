package com.jmendozat13.checkinapp.delivery.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jmendozat13.checkinapp.R
import com.jmendozat13.checkinapp.delivery.theme.CheckInAppTheme
import com.jmendozat13.checkinapp.delivery.theme.Header04_Bold
import com.jmendozat13.checkinapp.delivery.theme.Header05
import com.jmendozat13.checkinapp.delivery.theme.Header05_Bold
import com.jmendozat13.checkinapp.delivery.theme.Light01
import com.jmendozat13.checkinapp.delivery.theme.Paragraph01
import com.jmendozat13.checkinapp.delivery.views.components.CustomButtonPrimary
import com.jmendozat13.checkinapp.delivery.views.components.CustomSocialButtons
import com.jmendozat13.checkinapp.delivery.views.components.CustomTextField

@Composable
fun LoginScreen(navigate: () -> Unit) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LoginHead(modifier = Modifier.weight(1f))
            LoginContent(navigate = navigate)

        }
    }
}

@Composable
fun LoginHead(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.align(alignment = Alignment.Center),
            painter = painterResource(R.drawable.ic_scan_logo),
            contentDescription = ""
        )
    }
}

@Composable
fun LoginContent(modifier: Modifier = Modifier, navigate: () -> Unit) {
    Card(
        modifier = modifier.padding(12.dp),
        colors = CardDefaults.cardColors(containerColor = Light01)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("YaListo - Administrador", style = Header04_Bold)
                Text("Gestiona tu establecimiento", style = Paragraph01)
            }

            var identifier by remember { mutableStateOf("") }

            CustomTextField(
                label = "Identificador del establecimiento",
                value = identifier, onChangeValue = {
                    identifier = it
                })

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomButtonPrimary(title = "Ingresar") {
                    navigate()
                }
                Text("¿Has olvidado tu identificador?", style = Paragraph01)
            }

            CustomSocialButtons(title = "o ingresa con", onClickGoogle = {}, onClickFacebook = {})
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Text("¿No tienes una cuenta?", style = Header05)
                Text("SIGN UP", style = Header05_Bold)
            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    CheckInAppTheme {
        LoginScreen {

        }
    }
}