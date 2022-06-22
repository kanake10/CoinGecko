package com.example.geckocoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.geckocoin.presentation.navigation.NavItem
import com.example.geckocoin.presentation.screens.details.ExchangesDetailsScreen
import com.example.geckocoin.presentation.screens.exchanges.ExchangesScreen
import com.example.geckocoin.ui.theme.GeckoCoinTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeckoCoinTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavItem.Exchanges.route
                    ) {
                        composable(
                            route = NavItem.Exchanges.route
                        ) {
                            ExchangesScreen(navController)
                        }
                        composable(
                            route = NavItem.ExchangesDetails.route + "/{exchangesId}"
                        ) {
                            ExchangesDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}




