package com.cmota.unsplash.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cmota.unsplash.R

private val fontSizeLarge = 21.sp
private val fontSizeMedium = 17.sp
private val fontSizeSmall = 15.sp

private val AssistantFontFamily = FontFamily(
    Font(R.font.big_noodle_titling)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        color = colorAccent,
        fontFamily = AssistantFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = fontSizeMedium
    ),

    h2 = TextStyle(
        color = colorAccent,
        fontFamily = AssistantFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = fontSizeSmall
    ),

    h4 = TextStyle(
        color = colorAccent,
        fontFamily = AssistantFontFamily,
        fontSize = fontSizeLarge
    ),

    // Bottom bar

    subtitle1 = TextStyle(
        color = colorPrimary,
        fontFamily = AssistantFontFamily,
        fontSize = fontSizeSmall
    ),

    subtitle2 = TextStyle(
        color = colorPrimary,
        fontFamily = AssistantFontFamily,
        fontSize = fontSizeSmall
    )
)