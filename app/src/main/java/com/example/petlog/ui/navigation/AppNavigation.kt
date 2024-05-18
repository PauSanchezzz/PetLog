package com.example.petlog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petlog.ui.screens.AddPetScreen
import com.example.petlog.ui.screens.HomeScreen
import com.example.petlog.ui.screens.PetDetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route) {
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = AppScreens.AddPetScreen.route) {
            AddPetScreen()
        }
        composable(route = AppScreens.PetDetailScreen.route) {
            PetDetailScreen()
        }
    }

}