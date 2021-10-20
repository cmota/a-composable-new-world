package com.cmota.unsplash.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmota.unsplash.R
import com.cmota.unsplash.components.UnsplashTopAppBar
import com.cmota.unsplash.shared.data.model.Image
import com.cmota.unsplash.ui.about.AboutContent
import com.cmota.unsplash.ui.home.HomeContent
import com.cmota.unsplash.ui.theme.typography


private val DEFAULT_SCREEN = BottomNavigationScreens.Home

@Composable
fun MainScreen(
    images: List<Image>
) {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            UnsplashTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = typography.h3,
                        color = MaterialTheme.colors.onBackground
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            )
        },

        bottomBar = {
            val bottomNavigationItems = listOf(
                BottomNavigationScreens.Home,
                BottomNavigationScreens.About
            )

            MainBottomBar(
                navController = navController,
                items = bottomNavigationItems
            )
        },

        content = {

            NavHost(navController, startDestination = DEFAULT_SCREEN.route) {
                composable(BottomNavigationScreens.Home.route) {
                    HomeContent(
                        images = images,
                    )
                }
                composable(BottomNavigationScreens.About.route) {
                    AboutContent()
                }
            }
        }
    )
}