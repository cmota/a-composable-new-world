package com.cmota.unsplash.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.cmota.unsplash.R

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val stringResId: Int,
    @DrawableRes val drawResId: Int
) {

    object Home : BottomNavigationScreens("Home", R.string.navigation_home, R.drawable.ic_home)
    object About : BottomNavigationScreens("About", R.string.navigation_about, R.drawable.ic_about)
}