package com.cmota.unsplash.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cmota.unsplash.ui.theme.colorAccent
import com.cmota.unsplash.ui.theme.colorAccent25Transparency
import com.cmota.unsplash.ui.theme.colorContent
import com.cmota.unsplash.ui.theme.colorPrimary

private lateinit var selectedIndex: MutableState<Int>

@Composable
fun MainBottomBar(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {

    Column {
        Row(
            modifier = Modifier
              .fillMaxWidth()
              .height(1.dp)
              .background(color = colorAccent25Transparency)
        ) {}

        AppBottomNavigation(
            navController = navController,
            items = items
        )
    }
}

@Composable
private fun AppBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation(
        backgroundColor = colorPrimary
    ) {

        selectedIndex = remember { mutableStateOf(0) }

        items.forEachIndexed { index, screen ->

            val isSelected = selectedIndex.value == index

            val style = if (isSelected) {
                typography.subtitle1.copy(color = colorPrimary)
            } else {
                typography.subtitle2.copy(color = colorAccent)
            }

            BottomNavigationItem(
                modifier = Modifier
                    .background(color = colorContent),
                icon = {
                    Icon(
                        painter = painterResource(id = screen.drawResId),
                        contentDescription = stringResource(id = screen.stringResId)
                    )
                },
                label = {
                    Text(
                        stringResource(id = screen.stringResId),
                        style = style
                    )
                },
                selected = isSelected,
                selectedContentColor = colorPrimary,
                unselectedContentColor = colorAccent,
                alwaysShowLabel = true,
                onClick = {
                    if (!isSelected) {
                        selectedIndex.value = index
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}