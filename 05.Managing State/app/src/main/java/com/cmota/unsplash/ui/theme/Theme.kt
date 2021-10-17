package com.cmota.unsplash.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

val BottomNavigationHeight = 56.dp

@Composable
fun UnsplashTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}