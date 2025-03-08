package com.jmendozat13.checkinapp.delivery.views.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jmendozat13.checkinapp.R
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import com.jmendozat13.checkinapp.delivery.navigation.SignupScreenGraphScreen
import com.jmendozat13.checkinapp.delivery.theme.BlueGray900
import com.jmendozat13.checkinapp.delivery.theme.CheckInAppTheme
import com.jmendozat13.checkinapp.delivery.theme.Light01
import com.jmendozat13.checkinapp.delivery.theme.Orange700

@Composable
fun OnboardingScreen(navigateTo: (ScreenNavigationGraph) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.align(alignment = Alignment.TopEnd),
                painter = painterResource(R.drawable.ellipse_2), contentDescription = ""
            )
            Image(
                modifier = Modifier.align(alignment = Alignment.TopEnd),
                painter = painterResource(R.drawable.ellipse_1),
                contentDescription = ""
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter)
                    .size(260.dp),
                painter = painterResource(R.drawable.person_laptop),
                contentDescription = ""
            )

        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            textAlign = TextAlign.Center,
            text = "Gana visibilidad y clientes con YaListo",
            style = TextStyle(
                letterSpacing = 1.sp,
                color = Orange700,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp * 1f
            )
        )

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            textAlign = TextAlign.Center,
            text = "Digitaliza tu menú, aumenta tu visibilidad y conecta con más clientes",
            style = TextStyle(
                color = BlueGray900,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 14.sp * 1.2f
            )
        )
        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 64.dp),
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
            onClick = {
                navigateTo(SignupScreenGraphScreen)
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                textAlign = TextAlign.Center,
                text = "Continuar",
                style = TextStyle(
                    color = Orange700,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewOnboardingScreen() {
    CheckInAppTheme {
        OnboardingScreen {

        }
    }
}