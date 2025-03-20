package com.jmendozat13.checkinapp.delivery.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Header01_Bold = TextStyle(
    letterSpacing = 1.sp,
    color = Orange700,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 32.sp * 1f
)

val Header04_Bold = TextStyle(
    letterSpacing = 1.sp,
    color = BlueGray900,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 18.sp * 1f
)

val Header05 = TextStyle(
    letterSpacing = 1.sp,
    color = Gray500,
    fontSize = 16.sp,
    lineHeight = 16.sp * 1f
)

val Header05_Bold = TextStyle(
    letterSpacing = 1.sp,
    color = Orange700,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 16.sp * 1f
)

val Header05_SemiBold = TextStyle(
    letterSpacing = 1.sp,
    color = Orange700,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp * 1f
)

val Paragraph01_SemiBold = TextStyle(
    color = BlueGray900,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 14.sp * 1.2f
)

val Paragraph01 = TextStyle(
    color = BlueGray800,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 14.sp * 1.2f
)