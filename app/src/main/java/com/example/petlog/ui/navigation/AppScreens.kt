package com.example.petlog.ui.navigation

sealed class AppScreens (val route:String ){
    data object HomeScreen: AppScreens("home_screen")
    data object AddPetScreen: AppScreens("add_pet_screen")
    data object PetDetailScreen: AppScreens("pet_detail_screen")
}