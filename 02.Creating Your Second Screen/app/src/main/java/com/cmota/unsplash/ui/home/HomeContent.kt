package com.cmota.unsplash.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmota.unsplash.components.AddImagePreview
import com.cmota.unsplash.shared.data.model.Image
import com.cmota.unsplash.ui.theme.colorAccent
import com.cmota.unsplash.ui.theme.colorContent20Transparency
import com.cmota.unsplash.ui.theme.colorContent85Transparency
import com.cmota.unsplash.ui.theme.colorContentSecondary

@Composable
fun HomeContent(
    images: List<Image>
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),

        content = {
            items(images) {

                AddUnsplashImage(image = it)
            }
        }
    )
}

@Composable
fun AddUnsplashImage(image: Image) {

    Surface(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 8.dp
        ),
        color = Color.Transparent
    ) {

        AddImagePreview(
            url = image.urls.regular ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = colorContentSecondary)
        )

        val verticalGradientBrush = Brush.verticalGradient(
            colors = listOf(
                colorContent20Transparency,
                colorContent85Transparency
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(brush = verticalGradientBrush),
            verticalArrangement = Arrangement.Bottom
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = image.description ?: "",
                    fontSize = 17.sp,
                    color = colorAccent
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = image.user.username,
                    fontSize = 15.sp,
                    color = colorAccent,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

