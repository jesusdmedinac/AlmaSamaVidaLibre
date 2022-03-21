package com.mupper.almasanavidalibre.ui.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mupper.almasanavidalibre.ui.app.navigation.NavItem
import com.mupper.almasanavidalibre.ui.app.navigation.pages.MainPage

@Composable
fun AlmaSanaVidaLibreApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavItem.MainNavItem.baseRoute) {
        composable(NavItem.MainNavItem.baseRoute) { MainPage() }
    }
}