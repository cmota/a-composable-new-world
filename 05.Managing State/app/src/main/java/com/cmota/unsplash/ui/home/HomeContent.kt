package com.cmota.unsplash.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.cmota.unsplash.R
import com.cmota.unsplash.components.AddImagePreview
import com.cmota.unsplash.ui.theme.*
import com.cmota.unsplash.shared.data.model.Image

private const val TAG = "MainContent"

@Composable
fun HomeContent(
    images: List<Image>,
    onSearchAction: (String) -> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorContent
    ) {

        val search = remember { mutableStateOf("") }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),

            content = {

                item {
                    AddSearchField(search, onSearchAction)
                }

                items(images) {

                    AddUnsplashImage(image = it)
                }
            }
        )
    }
}

@Composable
fun AddSearchField(
    search: MutableState<String>,
    onSearchAction: (String) -> Unit
) {

    val focused = remember { mutableStateOf(false) }

    val contentColor = if (focused.value) {
        colorPrimary
    } else {
        colorAccent
    }

    OutlinedTextField(
        value = search.value,
        onValueChange = { value ->
            search.value = value
        },
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp)
          .onFocusChanged {
            focused.value = it.isFocused
          },
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_hint),
                style = typography.h4,
                color = colorAccent
            )
        },
        leadingIcon = {
            val icon = painterResource(id = R.drawable.ic_search)
            val description =
                stringResource(R.string.description_search)

            Image(
                painter = icon,
                contentDescription = description,
                colorFilter = ColorFilter.tint(color = contentColor)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            unfocusedBorderColor = colorAccent,
            leadingIconColor = colorAccent,
            cursorColor = colorAccent,
            textColor = colorAccent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            onSearchAction(search.value)
        }
    )
}

@Composable
fun AddUnsplashImage(image: Image) {

    Log.d(TAG, "item | image=${image}")

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
                    style = typography.h1,
                    color = colorAccent
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = image.user.username,
                    style = typography.h2,
                    color = colorAccent,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}