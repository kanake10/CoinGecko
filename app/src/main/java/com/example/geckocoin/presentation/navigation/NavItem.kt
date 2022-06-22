package com.example.geckocoin.presentation.navigation

sealed class NavItem(val route: String) {
    object Exchanges: NavItem("Exchanges")
    object ExchangesDetails: NavItem("ExchangesScreen")
}
