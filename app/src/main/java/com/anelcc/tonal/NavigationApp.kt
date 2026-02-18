package com.anelcc.tonal

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anelcc.tonal.presenter.MovementDetailsScreen
import com.anelcc.tonal.presenter.MovementListScreen
import com.anelcc.tonal.presenter.MovementViewModel


@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<MovementViewModel>()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            MovementListScreen(viewModel) {
                navController.navigate("details")
            }
        }
        composable("details") {
            MovementDetailsScreen(viewModel){
                navController.popBackStack()
            }
        }
    }
}
