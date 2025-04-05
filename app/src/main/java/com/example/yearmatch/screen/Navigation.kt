package com.example.yearmatch.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "countrySelection") {
        composable("countrySelection") { CountrySelectionScreen(navController) }
    }
}
