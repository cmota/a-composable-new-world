package com.cmota.unsplash.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cmota.unsplash.R
import com.cmota.unsplash.components.UnsplashTopAppBar
import com.cmota.unsplash.ui.theme.colorContent

@Composable
fun MainTopAppBar() {

    UnsplashTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = typography.h4,
            )
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = colorContent,
        elevation = 0.dp
    )
}