package com.cmota.unsplash.ui.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.compose.rememberNavController
import com.cmota.unsplash.shared.data.model.Image
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MainScreen(
    images: State<List<Image>?>,
    onSearchAction: (String) -> Unit,
    onRefreshAction: () -> Unit
) {

    val bottomNavigationItems = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.About
    )

    val navController = rememberNavController()
    navController.enableOnBackPressed(false)

    Scaffold(
        topBar = {
            MainTopAppBar()
        },
        bottomBar = {
            MainBottomBar(
                navController = navController,
                items = bottomNavigationItems
            )
        },
        content = {

            val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)

            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    onRefreshAction()
                }
            ) {
                MainContent(
                    navController = navController,
                    images = images,
                    onSearchAction = onSearchAction
                )
            }
        }
    )
}