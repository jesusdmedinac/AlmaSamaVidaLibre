package com.mupper.almasanavidalibre.ui.app.navigation

sealed class NavItem(
    val baseRoute: String,
) {
    object MainNavItem : NavItem("main")
}
