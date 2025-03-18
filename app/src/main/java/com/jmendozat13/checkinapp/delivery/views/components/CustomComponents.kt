package com.jmendozat13.checkinapp.delivery.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jmendozat13.checkinapp.R
import com.jmendozat13.checkinapp.delivery.theme.BlueGray900
import com.jmendozat13.checkinapp.delivery.theme.Gray100
import com.jmendozat13.checkinapp.delivery.theme.Gray400
import com.jmendozat13.checkinapp.delivery.theme.Light01
import com.jmendozat13.checkinapp.delivery.theme.Orange700

@Composable
fun CustomSocialButtons(
    modifier: Modifier = Modifier,
    title: String,
    onClickGoogle: () -> Unit,
    onClickFacebook: () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            textAlign = TextAlign.Center,
            text = title,
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
                    .clickable { onClickGoogle() }
                    .background(Gray100, RoundedCornerShape(8.dp))
            ) {
                Image(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    painter = painterResource(R.drawable.ic_google), contentDescription = ""
                )
            }

            Box(
                modifier = Modifier
                    .clickable { onClickFacebook() }
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

@Composable
fun CustomButtonPrimary(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth(),
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
        onClick = onClick
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            textAlign = TextAlign.Center,
            text = title,
            style = TextStyle(
                color = Light01,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun CustomButtonPrimaryOutline(modifier: Modifier = Modifier, onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth(),
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
        onClick = onClick
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
            .fillMaxWidth(),
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
