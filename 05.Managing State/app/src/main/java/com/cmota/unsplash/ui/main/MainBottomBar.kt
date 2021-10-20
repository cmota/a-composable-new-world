package com.cmota.unsplash.ui.main

import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.cmota.unsplash.ui.theme.colorAccent
import com.cmota.unsplash.ui.theme.colorPrimary
import com.cmota.unsplash.ui.theme.typography

private lateinit var selectedIndex: MutableState<Int>

@Composable
fun MainBottomBar(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {

    BottomNavigation(
        backgroundColor = colorPrimary
    ) {

        selectedIndex = remember { mutableStateOf(0) }

        items.forEachIndexed { index, screen ->

            val isSelected = selectedIndex.value == index

            BottomNavigationItem(
                modifier = Modifier.background(color = MaterialTheme.colors.background),
                icon = {
                    Icon(
                        painter = painterResource(id = screen.drawResId),
                        contentDescription = stringResource(id = screen.stringResId)
                    )
                },
                label = {
                    Text(
                        stringResource(id = screen.stringResId),
                        style = typography.subtitle1
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