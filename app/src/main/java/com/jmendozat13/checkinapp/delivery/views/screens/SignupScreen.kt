package com.jmendozat13.checkinapp.delivery.views.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jmendozat13.checkinapp.R
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import com.jmendozat13.checkinapp.delivery.theme.BlueGray900
import com.jmendozat13.checkinapp.delivery.theme.CheckInAppTheme
import com.jmendozat13.checkinapp.delivery.theme.Gray100
import com.jmendozat13.checkinapp.delivery.theme.Gray400
import com.jmendozat13.checkinapp.delivery.theme.Light01
import com.jmendozat13.checkinapp.delivery.theme.Orange700
import com.jmendozat13.checkinapp.delivery.viewmodels.UserAccountViewModel
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
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(84.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
                text = "Crear Cuenta",
                style = TextStyle(
                    letterSpacing = 1.sp,
                    color = Orange700,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp * 1f
                )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
                text = "Únete a nuestra comunidad de restaurantes y atrae más visitas",
                style = TextStyle(
                    color = BlueGray900,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 14.sp * 1.2f
                )
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

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Orange700,
                    contentColor = Orange700
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Orange700
                ),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
                onClick = {
                    userAccountViewModel.sendRegisterUserAccount(
                        name = names,
                        email = email,
                        phoneNumber = phoneNumber
                    )
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    textAlign = TextAlign.Center,
                    text = "Registrar",
                    style = TextStyle(
                        color = Light01,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Light01,
                    contentColor = Light01
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Orange700
                ),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
                onClick = { }
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    textAlign = TextAlign.Center,
                    text = "Ya tengo una cuenta",
                    style = TextStyle(
                        color = Orange700,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
                text = "o ingresa con",
                style = TextStyle(
                    color = BlueGray900,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 14.sp * 1.2f
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Box(
                    modifier = Modifier
                        .background(Gray100, RoundedCornerShape(8.dp))
                ) {
                    Image(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        painter = painterResource(R.drawable.ic_google), contentDescription = ""
                    )
                }

                Box(
                    modifier = Modifier
                        .background(Gray100, RoundedCornerShape(8.dp))
                ) {
                    Image(
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                        painter = painterResource(R.drawable.ic_facebook), contentDescription = ""
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        userAccountViewModel.navigation.collectLatest { navigateTo(it) }
    }
}


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onChangeValue: (String) -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = value,
        onValueChange = onChangeValue,
        textStyle = TextStyle(
            color = BlueGray900,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp * 1.2f
        ),
        shape = RoundedCornerShape(0.dp),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Light01,
            unfocusedContainerColor = Light01,
            disabledContainerColor = Gray400,
            errorContainerColor = Color.Red,
            unfocusedIndicatorColor = Gray400,
            focusedIndicatorColor = Gray400
        ),
        singleLine = true,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    color = Gray400,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 12.sp * 1.2f
                )
            )

        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSignupScreen() {
    CheckInAppTheme {
        SignupScreen {

        }
    }
}