package com.cmota.unsplash.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.livedata.observeAsState
import com.cmota.unsplash.ui.main.MainScreen
import com.cmota.unsplash.ui.theme.UnsplashTheme

class MainActivity : AppCompatActivity() {

    private val unsplashViewModel: UnsplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        unsplashViewModel.fetchImages()

        setContent {

            val images = unsplashViewModel.images.observeAsState()

            UnsplashTheme {
                MainScreen(
                    images = images,
                    onSearchAction = { search -> unsplashViewModel.searchForATopic(search) },
                    onRefreshAction = { unsplashViewModel.fetchImages() }
                )
            }
        }
    }
}